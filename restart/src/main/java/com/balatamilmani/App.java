package com.balatamilmani;

/**
 * App A - Always throws Exception
 * App P 0 - Throws Exception, for any other int values it runs well
 * App - No args, runs well
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        int counter = 0;
        boolean keepRunning = true;
        
    	System.out.println( "Starting main client!" );
        if(args != null & args.length>0){
            if("A".equals(args[0]) ||
            		("P".equals(args[0]) & 0 == Integer.parseInt(args[1]))
            				){
            	throw new Exception("Terminationg with Exception");
            }        	
        }

        //Keep running
        while(keepRunning){
        	counter++;
        	Thread.sleep(2000);
        	System.out.println("Waking up after a minute, will go to sleep again");
        	if(counter == 5){
        		keepRunning = false;
        	}
        }
        
        System.out.println("Exiting from Main");
    }
}
