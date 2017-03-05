package ss.labs.pokemon;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import java.util.Random;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner data=new Scanner(System.in);

        //TODO declare and initiate a Scanner
        ArrayList<PokemonData> pokedex=new ArrayList();
        //TODO declare and initiate pokedex as an ArrayList to store pokemon data
        HashMap<String,Integer> typeCountMap=new HashMap();
        //TODO declare and initiate typeCountMap as a HashMap to count the number of each types of pokemon

        System.out.println("Enter the Number of pokemon in the pokedex:");
        //TODO 0: scan the number of the testData from user input
        int datacounts=data.nextInt();
        //TODO use a loop to read several input data
        for(int i=0;i<datacounts;i++)
        {
            System.out.println("Enter pokemon name:");
            //TODO 1-1:scan pokemon name and save to a variable from user input
            String name=data.next();
            System.out.println("Enter pokemon type:");
            //TODO 1-2:scan pokemon type and save to a variable
            String type=data.next();
            System.out.println("Enter pokemon's move name:");
            //TODO 1-3:scan pokemon move's name
            String move=data.next();
            //TODO 2-1:create a new pokemon data from the above variables
            PokemonData temp= new PokemonData(name,type.toLowerCase(),move);
            //TODO 2-2:add the pokemon data into pokedex
            pokedex.add(temp);
            //TODO 4: Tricky part!! get the value from the type counting map , add 1 and put it back (multiple line
            boolean isContain=typeCountMap.containsKey(temp.type);
            if (!isContain){
                typeCountMap.put(temp.type,1);
            }
        }
            System.out.println("Morris starts his adventure.");
            Random randomPokemonNum = new Random();
            int points=0;
            HashMap<String,Integer>catchtypecount = new HashMap();
        do{
            PokemonData randomPokemon =pokedex.get(randomPokemonNum.nextInt(pokedex.size()));
            System.out.println("Morris encounters a new pokemon.");
            System.out.println("Pokemon: "+randomPokemon.name+" Type: "+randomPokemon.type+" Move: "+randomPokemon.move);
            System.out.println("What to react now,run or catch?");
            String amove = data.next();
            if(amove.equals("catch") && randomPokemon.type.equals("grass")){
                points++;
                boolean iscatch=catchtypecount.containsKey(randomPokemon.type);
                if(!iscatch){
                    catchtypecount.put(randomPokemon.type,1);
                }
                else{
                    catchtypecount.put(randomPokemon.type,catchtypecount.get(randomPokemon.type)+1);
                }
            }
            else if(amove.equals("run") && randomPokemon.type.equals("grass")){
                points--;
            }
            else if(amove.equals("catch") && !randomPokemon.type.equals("grass")){
                points--;
                boolean iscatch=catchtypecount.containsKey(randomPokemon.type);
                if(!iscatch){
                    catchtypecount.put(randomPokemon.type,1);
                }
                else{
                    catchtypecount.put(randomPokemon.type,catchtypecount.get(randomPokemon.type)+1);
                }
            }
            else if(amove.equals("run") && !randomPokemon.type.equals("grass")){
                points++;
            }
            else{
                if(amove.equals("quit")){
                    System.out.println("Morris takes a nap.");
                    break;
                }
                else{
                    System.out.println("Please key in \"run\",\"catch\",or\"quit\". ");
                }
            }
        }while(true);

        System.out.println("You quit the game");
        System.out.println("Score: "+points);
        for(HashMap.Entry<String,Integer> entry : catchtypecount.entrySet())
        {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        if(catchtypecount.size()==0)
        {
            System.out.println("No pokemon is caught.");
        }
        //TODO 5 print out the created pokemon information (multiple lines
            /*for(int i=0;i<pokedex.size();i++)
            {
                PokemonData tmpout=pokedex.get(i);
                System.out.println("Name:" + tmpout.name + "," + "Type:"+tmpout.type +","+"Move:"+tmpout.move);
            }*/
        //TODO 6 print out how many type of pokemons in the pokedex
            //System.out.println("Toal types are "+typeCountMap.size()+" .");
    }
}
