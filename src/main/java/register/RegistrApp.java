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

        String title = new String(register.get(1));
        String link = new String(register.get(2));

        String[] titleSplitted = title.split(",");
        String[] linkSplitted = link.split(",");

        if(titleSplitted.length != 5)
            throw new InvalidInformationException("invalid information!");

        String[] semestreSplitted = titleSplitted[0].split(" ");

        if(semestreSplitted[1].length() != 6 )
            throw new InvalidInformationException("invalid information!");
        else if(semestreSplitted[2] != "EN")
            throw new InvalidInformationException("invalid information!");
        else if(semestreSplitted[2] != "ES")
            throw new InvalidInformationException("invalid information!");

        actor.registerInformation(title, link);


        return "sdfas";
    }


}