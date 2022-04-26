package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/*
 
 
import java.util.Date;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

// @author Henry Joe Wong Urquiza

public class Programacion {
    //El horario de la tarea
    private Scheduler horario;

    //Metodo que crea el horario
    private void crearProgramacion() {

        try {
            //Creando la programacion
            SchedulerFactory factoria = new StdSchedulerFactory();
            //Obteniendo el horario
            horario = factoria.getScheduler();
            //Damos inicio al horario
            horario.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    //Metodo que da la informacion mas detallada sobre el horario, como hora de inicio de la tarea y cada
    //cuanto tiempo se ejecute la tarea
    public void iniciarTarea() {
        if (this.horario == null) {
            this.crearProgramacion();
        }
        //Informacion sobre la tarea
        //La informacion que se pide un nombre, a que grupo pertenece         //y a que clase que implemente de Job va a ser llamado
     //   JobDetail job = new JobDetail("TareaAutomatizar", null, Hlr_BuenaV.class);
        //Creamos un trigger y le decimos cada cuanto queremos que se invoque la tarea o Job
        //Tenemos los metodos como los siguientes
        //TriggerUtils.makeSecondlyTrigger(tiempo) --> Para invocar una tarea cada cierto segundos
        //TriggerUtils.makeMinutelyTrigger(1); //--> Para invocar una tarea cada cierto minutos
        //TriggerUtils.makeHourlyTrigger(tiempo) --> Para invocar una tarea cada cierta hora
        //Entre otros mas que pueden revisar en la documentacion
        Trigger trigger = TriggerUtils.makeHourlyTrigger(24);
        //En que momento va a iniciar la tarea
        trigger.setStartTime(new Date());
        //El nombre del trigger que debe ser unico
        trigger.setName("CadaCincoSegundos");
       try {
          //  this.horario.scheduleJob(job, trigger);
        } catch (SchedulerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        try {
            new Programacion().iniciarTarea();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

*/
