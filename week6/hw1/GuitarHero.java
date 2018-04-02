
import java.util.HashMap;

/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    //private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static HashMap<Character, Integer> keyMap;

    public static void hashKeyboard() {
        keyMap = new HashMap<Character, Integer>();
        for(int i = 0; i < 37; i++) {
            keyMap.put(keyboard.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        /* create 37 guitar strings, for concert A and C */
        synthesizer.GuitarString[] stringArray = new synthesizer.GuitarString[37];
        hashKeyboard();
        for(int i = 0; i < 37; i++) {
            double CONCERT = CONCERT_A * Math.pow(2, (i - 24) / 12.0);
            stringArray[i] = new synthesizer.GuitarString(CONCERT);
        }
        // synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);
        // synthesizer.GuitarString stringC = new synthesizer.GuitarString(CONCERT_C);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if(keyMap.get(key) == null) {
                    throw new NullPointerException("No corresponded key!");
                }
                int value = (int) keyMap.get(key);
                stringArray[value].pluck();
            }

        /* compute the superposition of samples */
            double sample = 0.0;
            for(int j = 0; j < 37; j++) {
                sample += stringArray[j].sample();
            }

        /* play the sample on standard audio */
            StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            for(int k = 0; k < 37; k++) {
                stringArray[k].tic();
            }
        }
    }
}

