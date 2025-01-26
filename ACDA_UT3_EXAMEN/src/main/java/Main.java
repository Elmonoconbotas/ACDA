import constants.PartidaConstans;
import model.*;
import service.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Main {
    private static final TorneoService torneoService = new TorneoService();
    private static final PartidaService partidaService = new PartidaService();
    private static final EquipoService equipoService = new EquipoService();
    private static final JugadorService jugadorService = new JugadorService();

    public static void main(String[] args) {
        // Crear torneo
        Torneo torneo = new Torneo("Torneo1",new Date(), new Date(), BigDecimal.valueOf(100));
        torneoService.create(torneo);

        // Crear equipos
        Equipo equipo1 = new Equipo("Equipo_1", new Date(), "España", BigDecimal.valueOf(10000.50), null);
        Equipo equipo2 = new Equipo("Equipo_3", new Date(), "asdf", BigDecimal.valueOf(500), null);
        Equipo equipo3 = new Equipo("Equipo_3", new Date(), "fdsa", BigDecimal.valueOf(100), null);
        equipoService.create(equipo1);
        equipoService.create(equipo2);
        equipoService.create(equipo3);

        // Jugadores equipo 1
        Jugador jugador1 = new Jugador("Jugador_1", "Alias_1", new Date(), "España", equipo1);
        Jugador jugador2 = new Jugador("Jugador_2", "Alias_2", new Date(), "España", equipo1);
        jugadorService.create(jugador1);
        jugadorService.create(jugador2);

        // Jugadores equipos 2 y 3
        Jugador jugador3 = new Jugador("Jugador_3", "Alias_3", new Date(), "asdf", equipo2);
        Jugador jugador4 = new Jugador("Jugador_4", "Alias_4", new Date(), "fdsa", equipo3);
        jugadorService.create(jugador3);
        jugadorService.create(jugador4);

        // Asignar capitanes
        equipo1.setCapitan(jugador1);
        equipo2.setCapitan(jugador3);
        equipo3.setCapitan(jugador4);
        equipoService.update(equipo1);
        equipoService.update(equipo2);
        equipoService.update(equipo3);

        // Crear partidas
        Partida partida1 = new Partida(equipo1, equipo2, torneo, PartidaConstans.RESULTADO_EMPATE, 45, new Date());
        Partida partida2 = new Partida(equipo1, equipo3, torneo, PartidaConstans.RESULTADO_GANA_EQUIPO_1, 45, new Date());
        Partida partida3 = new Partida(equipo2, equipo3, torneo, PartidaConstans.RESULTADO_GANA_EQUIPO_2, 45, new Date());
        partidaService.create(partida1);
        partidaService.create(partida2);
        partidaService.create(partida3);

        // Participaciones al torneo
        Participa participa1 = new Participa(1, torneo, equipo1);
        Participa participa2 = new Participa(2, torneo, equipo2);
        Participa participa3 = new Participa(3, torneo, equipo3);
        torneo.getParticipantes().add(participa1);
        torneo.getParticipantes().add(participa2);
        torneo.getParticipantes().add(participa3);
        torneoService.update(torneo);

        // Consultas
        Equipo equipoConDatos = equipoService.findByIdWithJugadoresYPartidas(equipo1.getEquipoID());
        System.out.println("Equipo con Datos: \n" + equipoConDatos);

        List<Equipo> equiposConPresupuesto = equipoService.findByPresupuestoGreatherThan(BigDecimal.valueOf(400));
        System.out.println("\n\n\nEquipos con presupuesto:");
        for (Equipo equipo : equiposConPresupuesto)
            System.out.println(equipo);

        List<Equipo> equiposGanadores = equipoService.findWinners();
        System.out.println("\n\n\nEquipos ganadores:");
        for (Equipo equipo : equiposGanadores)
            System.out.println(equipo);
    }
}
