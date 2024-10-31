// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class robotMoves {
    public static void main(String[] args) {
        
        List<String> commands = new ArrayList<>();
        commands.add("RGRG");
        commands.add("G");
        commands.add("L");
        commands.add("RGLG");
        doesCircleExist(1, commands);
    }
    public static void doesCircleExist(int n, List<String> commands) {
        int[][] dir = {{0, 1}, {1, 0}, {0 , -1}, {-1, 0}};
        for(String command: commands) {
            int index = 0;
            int x = 0, y = 0;
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < command.length(); j++) {
                    char c = command.charAt(j);
                    if(c == 'R') {
                        index = (index + 1)%4;
                    } else if(c == 'L') {
                        if(index == 0) {
                            index = 4;
                        }
                        index--;
                    } else {
                        x += dir[index][0];
                        y += dir[index][1];
                    }
                }
            }
            if(x == 0 && y == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
    }
}