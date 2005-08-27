package reger.systemproperties;

import reger.core.SystemProperty;

public class EmailListenerHostName extends SystemProperty{

    public EmailListenerHostName(){
        setPropertyName("EMAILLISTENERHOSTNAME");
        setPropertyDefault("localhost");
        setPropertyDescription("This is the hostname that should appear to the right of the @ sign when email addresses are generated for users to send posts to their blogs.  It must be resolvable by users who wish to post.  For reger.com this valus is 'api.reger.com' which creates email addresses like 'fg4jhe7.pass@api.reger.com'.  The default of 'localhost' is generally unacceptable because users can't send email to it.  An IP address will suffice, but it won't be pretty.");
        load();
    }



}
