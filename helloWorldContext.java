import java.net.InetAddress;

public class helloWorldContext 
{

    public static void main(String[] args) 
    {
        
        StringBuilder sbHostname = new StringBuilder();

        String strUsername = null;
        String strHostname = null;
        int    iRC = 0;
        
        
        String FORMAT_HELLO_USERNAME = "Hello %s!  I am %s%n";
        String FORMAT_NETWORK_HOSTNAME = "%s is %s %n";
            
        strUsername = System.getProperty("user.name");
        
        System.out.printf
            (
                  FORMAT_HELLO_USERNAME
                , "World"
                , strUsername
            );
        
        
        iRC = getNetworkInfo
        (
            sbHostname
        );
        
 
        if (
                   ( iRC == 0)
                && (sbHostname != null)
            )
        {
            
            //get string
            strHostname = sbHostname.toString();
            
            System.out.printf
                (
                      FORMAT_NETWORK_HOSTNAME
                    , "Hostname"
                    , strHostname
                );
        }           
            
    }
    
    private static int getNetworkInfo
                        (
                            StringBuilder sbHostname
                        )
    {
        int iRC =0;
        InetAddress inetAddress;
        String      strHostname;
        
        try
        {
             /* 
                Get Network Object
             */           
             inetAddress = InetAddress.getLocalHost();
             
             if (inetAddress != null)
             {
                 
                /* 
                    Get Network Hostname
                */           
                strHostname = inetAddress.getHostName();
                 
                /* 
                    Capture Network Hostname into StringBuffer
                */  
                if (strHostname != null)
                {
                    sbHostname.append(strHostname);
                }
                
                iRC = 0;
                
             }
        }
        catch (java.net.UnknownHostException ex) 
        {
            iRC =-1;
            
            ex.printStackTrace();
        }
        
        return (iRC);
        
    }

}
