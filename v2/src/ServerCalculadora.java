import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
* Classe que implementa os métodos da Calculadora e disponibiliza o objeto remoto
*/
/**
* IFPB - Campina Grande<br>
* Curso: Telemática<br>
* Disciplina: Programação para ambientes distribuídos<br>
* Professor: Katyusco<br>
* Aluno: Ronycley Gonçalves Agra - 20141121044<br>
* Semestre: 2018.2<br><br>
*
* <h3>CALCULADORA SIMPLES COM USO DE JAVA RMI (REMOTE METHOD INVOCATION)<br>
* <b>Classe que implementa os métodos da Calculadora e disponibiliza o objeto remoto</b></h3>
* VERSÃO DO JAVA: 1.8<br>
* Exemplo de uso: <i>"java Server"</i><br>
* @author Ronycley Agra
* @since 10/06/2018
*/
public class ServerCalculadora implements Calculadora {

    
    public ServerCalculadora() {}

    /**
    * Realiza a soma de dois inteiros
    * @param a O primeiro número
    * @param b O segundo número
    * @return a + b
    */
    public long soma(long a, long b) throws RemoteException{
        return a+b;
    }

    /**
    * Realiza a subtração de um inteiro por outro
    * @param a O primeiro número
    * @param b O segundo número
    * @return a - b
    */
    public long subtrai(long a, long b) throws RemoteException{
        return a-b;
    }

    /**
    * Realiza a multiplicação entre dois inteiros
    * @param a O primeiro número
    * @param b O segundo número
    * @return a * b
    */
    public long multiplica(long a, long b) throws RemoteException{
        return a*b;
    }

    /**
    * Realiza a divisão entre dois inteiros
    * @param a O primeiro número
    * @param b O segundo número
    * @return a / b
    */
    public double divide(long a, long b) throws RemoteException{
        return (double)a/(double)b;
    }

    /**
    * Método que cria o objeto de servidor da calculadora e disponibiliza para os objetos clientes
    * @param args - Arrray de Strings passados na linha de comando
    */
    public static void main(String args[]) {
        try {
            ServerCalculadora obj = new ServerCalculadora();
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Calculadora", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
