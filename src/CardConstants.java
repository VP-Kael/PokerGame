//In this class, there three lists of constants. All of them are combined by
//the index of elements. RANKS and SUITS are the correct value of input, and
//RANKS_INTEGERS is set for conveniently transfer rank in String type into
//int type, linking by the index.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardConstants {
    public final static List<String> RANKS = new ArrayList<String>() {{
        addAll(Arrays.asList("2","3","4","5","6","7","8","9",
                "T","J","Q","K","A"));
    }};
    public final static List<String> SUITS = new ArrayList<String>() {{
        addAll(Arrays.asList("C","D","H","S"));
    }};
    public final static List<Integer> RANKS_INTEGERS =
            new ArrayList<Integer>(){{
        addAll(Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14));
        //Ace is the biggest, and A 2 3 4 5 is not straight. So the suitable
        //int value of Ace is 14
    }};
}
