package reger;

import reger.core.Debug;

import java.io.File;

import java.io.*;
import java.net.URL;
import java.net.JarURLConnection;
import java.util.jar.*;
import java.util.zip.*;
import java.util.Enumeration;

/**
 * Code broken and not used right now.
 */

/**
 * Finds implementations of particular interfaces.  Shouldn't be used
 * for paeg requests but can be used once per server startup or thereabouts
 * for plugin schemes, etc.
 */
public class FindInterfaceImplementations {

    /**
     * Display all the classes inheriting or implementing a given
     * class in the currently loaded packages.
     * @param tosubclassname the name of the class to inherit from
     */
    public static String find(String tosubclassname) {
        String out = "";
        try {
            Class tosubclass = Class.forName(tosubclassname);
            Package [] pcks = Package.getPackages();
            for (int i=0;i<pcks.length;i++) {
                out = out + find(pcks[i].getName(),tosubclass);
            }
        } catch (ClassNotFoundException ex) {
            Debug.errorsave(ex, "", "Class "+tosubclassname+" not found!");
        }
        return out;
    }

    /**
     * Display all the classes inheriting or implementing a given
     * class in a given package.
     */
    public static String[] find(String pckname, String tosubclassname) {
        String[] out=new String[0];
        try {
            Class tosubclass = Class.forName(tosubclassname);
            out = find(pckname,tosubclass);
        } catch (ClassNotFoundException ex) {
            Debug.errorsave(ex, "", "Class "+tosubclassname+" not found!");
        }
        return out;
    }

    /**
     * Display all the classes inheriting or implementing a given
     * class in a given package.
     * @param pckgname the fully qualified name of the package
     * @param tosubclass the Class object to inherit from
     */
    public static String[] find(String pckgname, Class tosubclass) {
        String[] implementingClasses=new String[0];
        //StringBuffer mb = new StringBuffer();
        // Translate the package name into an absolute path
        String name = new String(pckgname);
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        name = name.replace('.','/');

        // Get a File object for the package
        URL url = FindInterfaceImplementations.class.getResource(name);
        // URL url = tosubclass.getResource(name);
        // URL url = ClassLoader.getSystemClassLoader().getResource(name);
        //mb.append(name+"->"+url+"<br>");

        //reger.core.Util.logtodb(mb.toString());

        // Happens only if the jar file is not well constructed, i.e.
        // if the directories do not appear alone in the jar file like here:
        //
        //          meta-inf/
        //          meta-inf/manifest.mf
        //          commands/                  <== IMPORTANT
        //          commands/Command.class
        //          commands/DoorClose.class
        //          commands/DoorLock.class
        //          commands/DoorOpen.class
        //          commands/LightOff.class
        //          commands/LightOn.class
        //          RTSI.class
        //
        if (url==null) return new String[0];

        File directory = new File(url.getFile().replaceAll("%20", " "));

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
                    if (tosubclass.isInstance(o)) {
                        //mb.append("<br>" + classname + "<br>");
                        implementingClasses = reger.core.Util.addToStringArray(implementingClasses, pckgname+"."+classname);
                    }
                } catch (ClassNotFoundException cnfex) {
                    Debug.errorsave(cnfex, "");
                } catch (InstantiationException iex) {
                    // We try to instanciate an interface
                    // or an object that does not have a
                    // default constructor
                    //reger.core.Util.errorsave(iex);
                } catch (IllegalAccessException iaex) {
                    // The class is not public
                    //reger.core.Util.errorsave(iaex);
                }
            }
            }
        } else {
            try {
            // It does not work with the filesystem: we must
            // be in the case of a package contained in a jar file.
            JarURLConnection conn = (JarURLConnection)url.openConnection();


            String starts = conn.getEntryName();
            JarFile jfile = conn.getJarFile();
            Enumeration e = jfile.entries();
            while (e.hasMoreElements()) {
                ZipEntry entry = (ZipEntry)e.nextElement();
                String entryname = entry.getName();
                if (entryname.startsWith(starts)
                &&(entryname.lastIndexOf('/')<=starts.length())
                &&entryname.endsWith(".class")) {
                String classname = entryname.substring(0,entryname.length()-6);
                if (classname.startsWith("/"))
                    classname = classname.substring(1);
                classname = classname.replace('/','.');
                try {
                    // Try to create an instance of the object
                    Object o = Class.forName(classname).newInstance();
                    if (tosubclass.isInstance(o)) {
                        //mb.append(classname.substring(classname.lastIndexOf('.')+1));
                        implementingClasses = reger.core.Util.addToStringArray(implementingClasses, classname);
                    }
                } catch (ClassNotFoundException cnfex) {
                    Debug.errorsave(cnfex, "");
                } catch (InstantiationException iex) {
                    // We try to instanciate an interface
                    // or an object that does not have a
                    // default constructor
                } catch (IllegalAccessException iaex) {
                    // The class is not public
                }
                }
            }
            } catch (IOException ioex) {
                Debug.errorsave(ioex, "");
            }
        }
        return implementingClasses;
    }






}
