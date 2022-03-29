   public int findPoisonedDuration(int[] timeSeries, int duration) {
    
        Stack<Integer> attack = new Stack<>();
        attack.push(timeSeries[0]);
        int totalLoss = 0;
        
        for(int i=1;i<timeSeries.length;i++){
            if(attack.peek()+duration>timeSeries[i]){
                totalLoss += duration - (timeSeries[i]-attack.peek());
            }
            attack.push(timeSeries[i]);
        }
        
        return duration*attack.size()-totalLoss;
