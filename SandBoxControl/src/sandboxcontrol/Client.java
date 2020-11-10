
package sandboxcontrol;


public class Client {
    private String host;
    private int port;
    
    public Client(){};
    public Client(String host, int port){
        this.host = host;
        this.port = port;
    }


    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    
    
}
