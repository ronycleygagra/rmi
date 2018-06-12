import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
/**
* IFPB - Campina Grande<br>
* Curso: Telemática<br>
* Disciplina: Programação para ambientes distribuídos<br>
* Professor: Katyusco<br>
* Aluno: Ronycley Gonçalves Agra - 20141121044<br>
* Semestre: 2018.2<br><br>
*
* <h3>CALCULADORA SIMPLES COM USO DE JAVA RMI (REMOTE METHOD INVOCATION)<br>
* <b>Classe cliente que invoca os métodos da calculadora remota</b></h3>
* VERSÃO DO JAVA: 1.8<br>
* Exemplo de uso <i>"java ClientCalculadora"</i> ou <i>"java ClientCalculadora [IP]"</i>, onde [IP] é o ip do servidor RMI que disponibiliza a calculadora remota<br>
* @author Ronycley Agra
* @since 10/06/2018
*/
public class ClientCalculadora {

    private ClientCalculadora() {}

    /**
    * Método que realiza a conexão com o servidor RMI e invoca os métodos da calculadora remota
    * @param args Arrray de Strings passados na linha de comando
    */
    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Calculadora stub = (Calculadora) registry.lookup("Calc_Ronycley");
            System.out.println("soma: " + stub.soma(5,7));
	        System.out.println("subtrai: " + stub.subtrai(5,7));
	        System.out.println("multiplica: " + stub.multiplica(5,7));
	        System.out.println("divide: " + stub.divide(7,0));
        } catch (RemoteException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.err.println("Divisão por zero: " + e.toString());
            //e.printStackTrace();
        } 
    }
}

