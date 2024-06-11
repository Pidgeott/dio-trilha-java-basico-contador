package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args)
    {
       /* analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);*/

        //selecaoCandidatos();

        //imprimirSelecionados();

        String [] candidatos = {"MATHEUS", "VINICIUS", "WILLIAM", "MIGUELITO", "EDUARDO"};
        for (String candidato : candidatos ) {
            entrandoEmContato(candidato);
        }

    }
    static void entrandoEmContato(String candidato)
    {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        }while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " +candidato+ " NA " + tentativasRealizadas);
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " +candidato+ ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas);

    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados()
    {
        String [] candidatos = {"MATHEUS", "VINICIUS", "WILLIAM", "MIGUELITO", "EDUARDO"};
        System.out.println("Imprimindo a lista de candidatos, informando o índice do elemento");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de nº " + (i+1) + " é " + candidatos[i]);
        }
        
        // Aplicação do foreach

        for (String candidato : candidatos ) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecaoCandidatos()
    {
        String [] candidatos = {"MATHEUS", "VINICIUS", "WILLIAM", "MIGUELITO", "EDUARDO",
                                "CYUVERLANIA", "CANDIDO", "MUSTAFA", "MOHAMED", "GALO"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salaraioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário: " + salarioPretendido);
            if (salaraioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }

    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void analisarCandidato(double salarioPretendido)
    {
        double salaraioBase = 2000.0;

        if (salaraioBase > salarioPretendido)
        {
            System.out.println("Ligar para o candidato");
        }else if (salaraioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }else {
            System.out.println("Aguardando demais candidatos");

        }
    }


}


