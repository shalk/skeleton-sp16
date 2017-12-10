/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */

        synthesizer.GuitarString[] stringArray = new synthesizer.GuitarString[37];

        for (int i = 0; i < 37; i++) {
            stringArray[i] = new synthesizer.GuitarString(400 * Math.pow(2, (i - 24) / 12));
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    stringArray[index].pluck();
                } else {

                }
            }

        /* compute the superposition of samples */
            double sample = 0.0;
            for (synthesizer.GuitarString str : stringArray) {
                sample += str.sample();
            }

        /* play the sample on standard audio */
            StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            for (synthesizer.GuitarString str : stringArray) {
                str.tic();
            }
        }
    }
}

