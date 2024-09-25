import java.util.*;

class Conversation {


  public static void main(String[] arguments) {
    Scanner input = new Scanner(System.in);

    System.out.println("How many rounds? ");
    int numRounds = input.nextInt();
    input.nextLine();

    String transcript = "Hi there!  What's on your mind?";

    System.out.println("Hi there!  What's on your mind?");
    // String userResponse = input.nextLine();
    // updates the transcript with the user's response and the bot's response
    // transcript = transcript + "\n" + userResponse + "\n" + bot(userResponse);

    // starts a loop for the amount of rounds
    for (int i = 0; i < numRounds; i++) {  
      
      String nextResponse = input.nextLine();
      transcript = transcript + "\n" + nextResponse;
      String botResponse = bot(nextResponse);
      transcript = transcript + "\n" + botResponse;


    }

    System.out.println("Goodbye!");

    transcript = transcript + "\n" + "Goodbye!";

    input.close();

    System.out.println("TRANSCRIPT: \n" + transcript);

  }


    //mirrors a response or returns a random response
    public static String bot(String response) {

      String botResponse = "";
      String[] ranResponses = {"So interesting!", "Mmm-hm.", "Tell me more!", "I see."};
      Random rand = new Random();

      //if the user input contains any of these words that can be mirrored, replace them. otherwise, provide a random response
      if (response.contains("I") || response.contains("I'm") || response.contains("you") || response.contains("my") ||
      response.contains("me") || response.contains("your") || response.contains("am") ) {

        //mirrors I'm
        if (response.contains("I'm")) {
          if (response.indexOf("I'm") != 0) {
            botResponse = response.replace("I'm", "you're");
          }
          else {
            botResponse = response.replace("I'm", "You're");
          }
        }
        // mirrors I and me
        if (response.contains(" I ")) {
          botResponse = response.replace("I","you");
        }
        if (response.contains("I") && response.indexOf("I") == 0) {
          botResponse = response.replace("I","You");
        }
        if (response.contains(" me ")) {
          botResponse = response.replace("me","you");
        }
        //mirrors am
        if (response.contains(" am ")) {
          botResponse = response.replace("am","are");
        }
        //mirrors are
        if (response.contains(" are ")) {
          botResponse = response.replace("are","with");
        }
        //mirrors you
        if (response.contains(" you ")) {
          botResponse = response.replace("you","I");
        }
        //mirrors my
        if (response.contains(" my ")) {
          botResponse = response.replace("my","your");
        }
        //mirrors your
        if (response.contains(" your ")) {
          botResponse = response.replace("your","my");
        }

      botResponse = botResponse.replace(".","?");
      System.out.println(botResponse);
      return botResponse;
      }

      //choose random response from array
      else {

        botResponse = ranResponses[rand.nextInt(ranResponses.length-1)];

        System.out.println(botResponse);

        return botResponse;

      }

    }


    // You will start the conversation here.

   
  }

