class Solution {
    public List<String> readBinaryWatch(int turnedOn){
        int[] times = {1,2,4,8,1,2,4,8,16,32};
        List<String> list = new ArrayList<>();
        readBinaryWatch(times,0,0,list,0,0,turnedOn);
        return list;
    }
    public void readBinaryWatch(int[] times,int hour, int min,List<String> list,int start,int count,int turnedOn){
        if(count==turnedOn){
            if(hour<=11 && min<=59){
                StringBuilder s = new StringBuilder();
                s.append(Integer.toString(hour)+':');
                if(min<10){
                    s.append('0'+Integer.toString(min));
                }
                else{
                    s.append(Integer.toString(min));
                }
                list.add(s.toString());
            }
            return;
        }
        for(int i=start;i<times.length;i++){
            if(!isHour(i))min+=times[i];
            else hour+=times[i];
    
            readBinaryWatch(times,hour,min,list,i+1,count+1,turnedOn);

            if(!isHour(i)) min-=times[i];
            else hour-=times[i];
        }
    }
    public boolean isHour(int position) {
        return position >= 0 && position <= 3;
    }
}
