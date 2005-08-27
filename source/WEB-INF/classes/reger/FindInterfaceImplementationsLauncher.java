package reger;



import java.io.*;
import java.net.*;


/**
 * Code broken and not used right now.
 */

/**
 * Used as part of FindInterfaceImplementations.
 * http://www.javaworld.com/javaworld/javatips/jw-javatip113.html
 */
public class FindInterfaceImplementationsLauncher {

    public static void find(String pckgname) {
        // Translate the package name into an absolute path
        String name = new String(pckgname);
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        name = name.replace('.','/');

        // Get a File object for the package
        URL url = FindInterfaceImplementationsLauncher.class.getResource(name);
        File directory = new File(url.getFile());

        // New code
        // ======
        if (directory.exists()) {
            // Get the list of the files contained in the package
            String [] files = directory.list();
            for (int i=0;i<files.length;i++) {

                // we are only interested in .class files
                if (files[i].endsWith(".class")) {
                    // removes the .class extension
                    String classname = files[i].substring(0,files[i].length()-6);
                    try {
                        // Try to create an instance of the object
                        Object o = Class.forName(pckgname+"."+classname).newInstance();
                        //if (o instanceof Command) {
                            //System.out.println(classname);
                        //}
                    } catch (ClassNotFoundException cnfex) {
                        System.err.println(cnfex);
                    } catch (InstantiationException iex) {
                        // We try to instanciate an interface
                        // or an object that does not have a
                        // default constructor
                    } catch (IllegalAccessException iaex) {
                        // The class is not public
                    }
                }
            }
        }
    }

//    public static void main(String[] args){
//	if (args.length>0) {
//	    try {
//		    Command command = (Command)Class.forName("commands."+args[0]).newInstance();
//		    command.process();
//	    } catch (Exception ex) {
//		    System.out.println("Invalid command");
//		    System.out.println("Available command");
//		    find("commands");
//	    }
//	} else {
//	    System.out.println("Usage: Launcher <command>");
//	}
//    }


}
