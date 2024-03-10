package com.afrancop05.chatweb;

import java.io.Serializable;

public class Mensaje implements Serializable {
    private String usuario;
    private String mensaje;

    public Mensaje(String _usuario, String _mensaje) {
        this.usuario = _usuario;
        this.mensaje = _mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getMensaje() {
        return mensaje;
    }
}