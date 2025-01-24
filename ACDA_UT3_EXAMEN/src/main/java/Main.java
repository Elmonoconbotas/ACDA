import model.*;
import service.*;

import java.math.BigDecimal;

public class Main {
    //SERVICES
    private static EquipoService equipoService = new EquipoService();
    private static JugadorService jugadorService = new JugadorService();
    private static ParticipaService participaService = new ParticipaService();
    private static PartidaService partidaService = new PartidaService();
    private static TorneoService torneoService = new TorneoService();
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        torneo.setNombre("Torneo1");
        torneo.setPremio(BigDecimal.valueOf(17));

        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Equipo equipo3 = new Equipo();
        equipo1.setNombre("equipo1");
        equipo2.setNombre("equipo2");
        equipo3.setNombre("equipo3");

        equipo1.setPais("pais1");
        equipo2.setPais("pais2");
        equipo3.setPais("pais3");

        equipo1.setPresupuesto(BigDecimal.valueOf(1000));
        equipo2.setPresupuesto(BigDecimal.valueOf(2000));
        equipo3.setPresupuesto(BigDecimal.valueOf(3000));

        equipoService.create(equipo1);
        equipoService.create(equipo2);
        equipoService.create(equipo3);

        Partida partida1 = new Partida();
        Partida partida2 = new Partida();
        Partida partida3 = new Partida();

        partida1.setDuracion(5);
        partida2.setDuracion(6);
        partida3.setDuracion(7);

        partida1.setResultado(1);
        partida2.setResultado(2);
        partida3.setResultado(4);

        partida1.setEquipoLocal(equipo1);
        partida1.setEquipoVisitante(equipo2);
        partida2.setEquipoLocal(equipo3);
        partida2.setEquipoVisitante(equipo1);
        partida3.setEquipoLocal(equipo2);
        partida3.setEquipoVisitante(equipo3);

        partidaService.create(partida1);
        partidaService.create(partida2);
        partidaService.create(partida3);


        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();

        jugador1.setNombreApellidos("jugador1");
        jugador1.setAlias("alias1");
        jugador2.setNombreApellidos("jugador2");
        jugador2.setAlias("alias2");
        jugador3.setNombreApellidos("jugador3");
        jugador3.setAlias("alias3");
        jugador4.setNombreApellidos("jugador4");
        jugador4.setAlias("alias4");

        jugador1.setEquipo(equipo1);
        jugador2.setEquipo(equipo1);
        jugador3.setEquipo(equipo2);
        jugador4.setEquipo(equipo3);

        jugadorService.create(jugador1);
        jugadorService.create(jugador2);
        jugadorService.create(jugador3);
        jugadorService.create(jugador4);

        equipo1.setCapitan(jugador2);
        equipo2.setCapitan(jugador3);
        equipo3.setCapitan(jugador4);
    }
}
