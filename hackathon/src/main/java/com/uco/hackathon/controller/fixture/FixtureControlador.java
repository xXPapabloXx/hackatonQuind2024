package com.uco.hackathon.controller.fixture;

import com.uco.hackathon.domain.equipo.Equipo;
import com.uco.hackathon.domain.response.Response;
import com.uco.hackathon.domain.torneo.Torneo;
import com.uco.hackathon.service.equipo.EquipoServicio;
import com.uco.hackathon.service.torneo.TorneoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/fixture")
public class FixtureControlador {
    @Autowired
    private EquipoServicio equipoServicio;
    @Autowired
    private TorneoServicio torneoServicio;
    private static final String SUCCESS="Success";

    @GetMapping("{nombreTorneo}")
    public ResponseEntity<Response<String>> Fixturear(String nombreTorneo) {
        Response<String> response = new Response<>();
        Torneo torneo = torneoServicio.buscarPorNombre(nombreTorneo);
        if(torneo.isFixture()){
            response.addMessage("Torneo ya tiene fixture");
            return ResponseEntity.ok(response);
        }else{
            if (torneo.getEquipos().size()<2){
                response.addMessage("Equipos Insuficientes");
                return ResponseEntity.ok(response);
            }else{
                List<Equipo> equipos = torneo.getEquipos();
                for(Equipo equipo : equipos){
                    response.addMessage(equipo.getNombre());
                    equipo.setFixture(true);
                }
            }
        }
        return ResponseEntity.ok(response);
    }



}
