class Robot {

    private final int width, height, mod;
    private final int[] position;
    private String direction;
    
    private static final Map<String, int[]> directions = Map.of(
        "North", new int[]{0, 1},
        "South", new int[]{0, -1},
        "East", new int[]{1, 0},
        "West", new int[]{-1, 0}
    );
    private static final Map<String, String> turns = Map.of(
        "North","West",
        "South", "East",
        "East", "North",
        "West", "South"
    );
    
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.mod = 2*width + 2*height - 4;
        this.direction = "East";
        this.position = new int[]{0,0};
    }
    
    public void step(int num) {
        num = num % mod;
        if(num == 0) {
            num = mod;
        }
        while(num > 0) {
            int[] dxy = this.directions.get(this.direction);
            if(isValidPosition(position[0]+dxy[0], position[1]+dxy[1])) {
                position[0]+=dxy[0];
                position[1]+=dxy[1];
                num--;
            } else {
                this.direction = this.turns.get(this.direction);   
            }
        }
    }
    
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    
    public int[] getPos() {
        return this.position;
    }
    
    public String getDir() {
        return this.direction;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */