import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Lab 4 Questions:
 * 28. for(String track: tracks) {
 *         loop body
 *      }
 * 29. boolean found = false;
 *     while(not found) {
 *         if(the keys are in the next place) {
 *             not found = false;
 *             }
 *      }
 * 30. int index = 10;
 *     while(index <=95) {
 *         System.out.println(index);
 *         index= index + 5;
 *      }
 *     
 * 31. int n = 10, sum = 0, i = 1;
 *     while(i<=n) {
 *        sum= sum +i;
 *        i= i+1;
 *        System.out.println(sum);
 *     }
 *      
 * 32. public int sum(int a, int b)
 *     {
 *         int sum = 0;
 *         while(a<=b) {
 *             sum = sum + a;
 *             a = a + 1;
 *      }
 * 33. public boolean isPrime(int n)
 *          while(int i = 2 && <= n-1) {
 *               if(n % i == 0);
 *                  return false;
 *                  i = i+1;
 *      }
 *         
 */

public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles(int index)
    {
        int position = index;
        for(String filename : files) {
            System.out.println(position + ":" + filename);
            position = index +1;
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    public void listMatching(String searchString)
    {
        for(String filename : files) {
            if(filename.contains(searchString)){
                boolean isMatch = true;
                // A match
                System.out.println(filename);
            }
            else {
                System.out.println("No match found.");
            }
        }
    }
    
    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    public void playSample(String BlindLemonJefferson)
    {
       for(String filename: files) {
           if(filename.contains(BlindLemonJefferson)) {
               player.playSample(filename);
           }
       }
    }
    
    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
}
