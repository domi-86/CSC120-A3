import java.util.*;

class Conversation {

    /** Array of strings to hold the conversation */
    private final String[] transcriptArr;
    /** Number of rounds in the conversation */
    private static int numRounds;
    private static String[] ranResponses;


    /**
     * Constructor
     * @param numRounds the number of rounds of conversation
     */
    public Conversation(int numRounds) {
        this.transcriptArr = new String[(numRounds * 2) + 2];
        this.numRounds = numRounds;
        this.ranResponses = new String[] {
            "So interesting!",
            "Mmm-hm.",
            "Tell me more!",
            "I see."
        };
    }


    public static int getRounds() {
        return numRounds;
    }


    /**
     * main method, asks for the number of rounds, then creates a Conversation object
     * and initiates the conversation
     * @param arguments
     */
    public static void main(String[] arguments) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many rounds? ");
        int numberRounds = scan.nextInt();
        scan.nextLine();


        Conversation c = new Conversation(numberRounds);

        System.out.println(c.convo());

        scan.close();

    }

    /**
     * convo
     * Contains the entire conversation
     * @return returns the transcript of the conversation
     */
    public String convo() {


        Scanner input = new Scanner(System.in);


        System.out.println("Hi there!  What's on your mind?");
        transcriptArr[0] = "Hi there!  What's on your mind?";


        /**
         * starts a loop for the amount of rounds, takes in a response, mirrors it until end of loop
         */
        for (int i = 0, j = 1; i < numRounds; i++, j += 2) {

            String nextResponse = input.nextLine();
            transcriptArr[j] = nextResponse;

            String botResponse = bot(nextResponse);
            transcriptArr[j + 1] = botResponse;


        }

        System.out.println("Goodbye!");
        transcriptArr[(1 + numRounds * 2)] = "Goodbye!";

        input.close();

        // convert array of strings into string
        return "TRANSCRIPT:\n" + getTranscript();


    }


    /**
     * bot
     * A method that takes in user's response, mirrors it if possible, and if not then it provides a random phrase
     * @param response
     * @return Returns string of a bot's mirrored response or a random phrase
     */
    public static String bot(String response) {

        String botResponse = response;
        Random rand = new Random();

        //if the user input contains any of these words that can be mirrored, replace them. otherwise, provide a random response
        if (response.contains("I") || response.contains("I'm") || response.contains("you") || response.contains("my") ||
            response.contains("me") || response.contains("your") || response.contains(" am")) {

            //mirrors I'm
            if (response.contains("I'm")) {
                if (response.indexOf("I'm") != 0) { //if I'm is not at the beginning of the sentence
                    botResponse = botResponse.replace("I'm", "you're");
                }
                if (response.startsWith("I'm")) {
                    botResponse = botResponse.replace("I'm", "You're");
                }
            }
            // mirrors I and me
            if (response.contains("I ") && response.indexOf("I ") != 0) {
                botResponse = botResponse.replace("I", "you");
            }
            if (response.contains("I ") && response.startsWith("I ")) {
                botResponse = botResponse.replace("I", "You");
            }
            if (response.contains(" me ")) {
                botResponse = botResponse.replace("me", "you");
            }
            //mirrors am
            if (response.contains(" am")) {
                botResponse = botResponse.replace("am", "are");
            }
            //mirrors are
            if (response.contains(" are ")) {
                botResponse = botResponse.replace("are", "am"); //change this
            }
            //mirrors you
            if (response.contains(" you ")) {
                botResponse = botResponse.replace("you", "I");
            }
            //mirrors my
            if (response.contains(" my ")) {
                botResponse = botResponse.replace("my", "your");
            }
            //mirrors your
            if (response.contains(" your ")) {
                botResponse = botResponse.replace("your", "my");
            }

            botResponse = botResponse.replace(".", "?");
            System.out.println(botResponse);
            return botResponse;
        }

        //choose random response from array
        else {

            botResponse = ranResponses[rand.nextInt(ranResponses.length - 1)];

            System.out.println(botResponse);

            return botResponse;

        }

    }

    public String getTranscript() {
        String transcript = "";
        for (String line: transcriptArr) {
            transcript = transcript + line + "\n";
        }

        return transcript;

    }


}