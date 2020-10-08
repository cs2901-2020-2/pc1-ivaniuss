package register;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.List;
import java.util.logging.Logger;

public class RegistrApp{

    static final Logger logger = Logger.getLogger(RegistrApp.class.getName());
    public RegistrApp() {
        logger.info("Starting regist...");
    }

    public void validation(StringBuilder title, StringBuilder link){

    }
    Actor actor = new Actor();

    public String validation(final List<String> register) throws InvalidInformationException {

        String title = register.get(1);
        String link = register.get(2);

        String[] titleSplitted = title.split(",");
        String[] linkSplitted = link.split("/");

        if(titleSplitted.length != 5)
            throw new InvalidInformationException("invalid information!");

        String[] semestreSplitted = titleSplitted[0].split(" ");

        if(semestreSplitted[1].length() != 6 )
            throw new InvalidInformationException("invalid information!");
        else if(semestreSplitted[2] != "EN")
            throw new InvalidInformationException("invalid information!");
        else if(semestreSplitted[2] != "ES")
            throw new InvalidInformationException("invalid information!");

        if (linkSplitted.length != 5 || linkSplitted[0] != "http:" || linkSplitted[1] != "" ||
         linkSplitted[2] != "utec.zoom.us" || linkSplitted[3] != "rec" || linkSplitted[4] != "share"
        )
            throw new InvalidInformationException("invalid information!");
        
        actor.registerInformation(title, link);


        return "validated";
    }


}