import java.rmi.Remote;
import java.rmi.RemoteException;
/**
* IFPB - Campina Grande<br>
* Curso: Telemática<br>
* Disciplina: Programação para ambientes distribuídos<br>
* Professor: Katyusco<br>
* Aluno: Ronycley Gonçalves Agra - 20141121044<br>
* Semestre: 2018.2<br><br>
*
* <h3>CALCULADORA SIMPLES COM USO DE JAVA RMI (REMOTE METHOD INVOCATION)<br>
* <b>Interface que define os métodos e extende o objeto remoto nativo</b></h3>
* VERSÃO DO JAVA: 1.8<br>
* @author Ronycley Agra
* @since 10/06/2018
*/
public interface Calculadora extends Remote {

    /**
    * Realiza a soma de dois inteiros
    * @param a O primeiro número
    * @param b O segundo número
    * @return a + b
    * @throws java.rmi.RemoteException Exceção de remote que pode ser lançada
    */
    public long soma(long a, long b) throws RemoteException;

    /**
    * Realiza a subtração de um inteiro por outro
    * @param a O primeiro número
    * @param b O segundo número
    * @return a - b
    * @throws java.rmi.RemoteException Exceção de remote que pode ser lançada
    */
    public long subtrai(long a, long b) throws RemoteException;

    /**
    * Realiza a multiplicação entre dois inteiros
    * @param a O primeiro número
    * @param b O segundo número
    * @return a * b
    * @throws java.rmi.RemoteException Exceção de remote que pode ser lançada
    */
    public long multiplica(long a, long b) throws RemoteException;

    /**
    * Realiza a divisão entre dois inteiros
    * @param a O primeiro número
    * @param b O segundo número
    * @return a / b
    * @throws java.rmi.RemoteException Exceção de remote que pode ser lançada
    */
    public long divide(long a, long b) throws RemoteException;
}

