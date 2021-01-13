package com.test.demo.tcp;

import com.ks.lib.tcp.Cliente;
import com.ks.lib.tcp.EventosTCP;
import com.ks.lib.tcp.Tcp;
import com.test.demo.service.SessionsService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component
public class TcpClient implements EventosTCP
{
    public static final String WS_ROUTE = "/sessions";

    @Autowired
    private SessionsService sessionsService;

    private Tcp tcp;

    @PostConstruct
    public void configure()
    {
        try
        {
            tcp = new Cliente();
            tcp.setIP("127.0.0.1");
            tcp.setPuerto(5000);
            tcp.setEventos(this);
            tcp.conectar();
        }
        catch (Exception e)
        {
            log.info("Error al crear el cliente TCP: {}", e);
        }
    }

    @Override
    public void conexionEstablecida(Cliente cliente)
    {
        log.info("Conexión establecida: {}", cliente.getIP());
    }

    @Override
    public void errorConexion(String s)
    {

    }

    @Override
    public void datosRecibidos(String s, byte[] bytes, Tcp tcp)
    {
        sessionsService.filterAndSend(s, bytes);
    }

    @Override
    public void cerrarConexion(Cliente cliente)
    {

    }

    @Override
    public void setLogger(Marker marker)
    {

    }
}
