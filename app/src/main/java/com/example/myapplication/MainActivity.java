package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    List<Item> Items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        SearchView searchView = findViewById(R.id.searchView);

        Items = new ArrayList<>();

        Items.add(new Item("spongebob", "Description: SpongeBob is a cheerful and optimistic sea sponge who lives in a pineapple under the sea. He works as a fry cook at the Krusty Krab and is known for his distinctive laugh and unwavering enthusiasm.\n" +
                "Personality: Friendly, hardworking, and always eager to help his friends, SpongeBob is a character full of energy and curiosity..", R.drawable.a));

        Items.add(new Item("Patrick Star", "Description: Patrick is SpongeBob's best friend, a pink starfish who lives under a rock. Despite his slow thinking and lack of common sense, he has a heart of gold.\n" +
                "Personality: Simple-minded, easy-going, and often lazy, Patrick is loyal and always up for an adventure with SpongeBob.", R.drawable.b));

        Items.add(new Item("Squidward ", "Description: Squidward is an octopus who lives in a moai (Easter Island head)-shaped house between SpongeBob and Patrick. He works as a cashier at the Krusty Krab and is often annoyed by SpongeBob and Patrick's antics.\n" +
                "Personality: Grumpy, cynical, and artistic, Squidward prefers peace and quiet and dreams of becoming a famous musician or artist.", R.drawable.c));

        Items.add(new Item("Mr. Krabs", "Description: Mr. Krabs is the money-obsessed owner of the Krusty Krab. He is a red crab who lives in an anchor-shaped house with his daughter, Pearl.\n" +
                "Personality: Greedy, thrifty, and sometimes scheming, Mr. Krabs cares deeply for his daughter and is protective of the Krabby Patty secret formula.\n", R.drawable.d));

        Items.add(new Item("Sandy Cheeks", "Description: Sandy is a squirrel from Texas who lives in an underwater dome and wears a diving suit to survive underwater. She is an accomplished scientist and karate practitioner.\n" +
                "Personality: Intelligent, adventurous, and tough, Sandy loves to challenge herself and is always ready for an exciting scientific experiment or physical activity.", R.drawable.e));

        Items.add(new Item("Plankton", "Description: Plankton is the owner of the Chum Bucket, a failing restaurant across the street from the Krusty Krab. He is constantly trying to steal the Krabby Patty secret formula.\n" +
                "Personality: Devious, cunning, and ambitious, Plankton often schemes to take down Mr. Krabs and make his restaurant successful, but his plans usually fail.", R.drawable.f));

        Items.add(new Item("Pearl Krabs", "Description: Pearl is Mr. Krabs' teenage daughter, a whale. She is a typical teenager who loves shopping, music, and spending time with her friends.\n" +
                "Personality: Cheerful, sociable, and sometimes dramatic, Pearl cares about her appearance and social life but loves her father despite his eccentricities.", R.drawable.g));

        Items.add(new Item("Gary the Snail", "Description: Gary is SpongeBob's pet snail, who communicates by meowing like a cat. He is intelligent and often helps SpongeBob out of tricky situations.\n" +
                "Personality: Calm, wise, and occasionally sarcastic, Gary is a loyal companion to SpongeBob and enjoys a relatively simple life.", R.drawable.h));

        Items.add(new Item("Mrs. Puff", "Description: Mrs. Puff is SpongeBob's boating school teacher. She runs the boating school where SpongeBob continuously fails to earn his boating license.\n" +
                "Personality: Patient, yet often exasperated by SpongeBob’s antics, Mrs. Puff tries her best to teach but often finds herself in unfortunate situations due to SpongeBob’s clumsiness.", R.drawable.j));

        Items.add(new Item("Mermaid Man", "Description: Mermaid Man is an elderly superhero who lives in a retirement home but occasionally comes out of retirement to save the day. He is SpongeBob and Patrick’s idol.\n" +
                "Personality: Brave but somewhat senile, Mermaid Man is always ready to save the day despite his old age.", R.drawable.z));

        Items.add(new Item("Barnacle Boy", "Description: Barnacle Boy is Mermaid Man's sidekick. He is also elderly and lives in a retirement home but is more level-headed than Mermaid Man.\n" +
                "Personality: Grumpy and often annoyed by Mermaid Man’s antics, Barnacle Boy still stands by his side as a loyal sidekick.", R.drawable.y));

        Items.add(new Item("Larry the Lobster", "Description: Larry the Lobster is a muscular lifeguard at Goo Lagoon. He is known for his strength and fitness.\n" +
                "Personality: Friendly and confident, Larry encourages others to stay fit and active. He often participates in various athletic activities.", R.drawable.l));

        Items.add(new Item("Squilliam Fancyson", "Description: Squilliam is Squidward’s wealthy and successful rival from high school. He often flaunts his success to make Squidward feel inferior.\n" +
                "Personality: Arrogant, condescending, and pretentious, Squilliam takes great pleasure in belittling Squidward and boasting about his own achievements.", R.drawable.o));

        Items.add(new Item("Bubble Bass", "Description: Bubble Bass is a recurring antagonist in the series known for his gluttonous appetite and deceptive behavior.\n" +
                "Personality: Arrogant, manipulative, and somewhat cowardly, Bubble Bass enjoys tormenting others, particularly SpongeBob.", R.drawable.m));


        Items.add(new Item("Man Ray", "Description: Man Ray is one of Mermaid Man and Barnacle Boy's arch-nemeses. He is a supervillain with a humanoid stingray appearance.\n" +
                "Personality: Evil and cunning, Man Ray often plots against Mermaid Man and Barnacle Boy, though his plans are usually foiled by SpongeBob and Patrick.", R.drawable.n));


        myAdapter = new MyAdapter(this, Items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAdapter.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.filter(newText);
                return false;
            }
        });
    }
}
