public class Solution {

        public static void main(String[] args){
            Student student  = new Student();
            Class studentCls = student.getClass();
            Method[] methods = studentCls.getDeclaredMethods();

            ArrayList<String> methodList = new ArrayList<>();
            for(Method method:methods){
                methodList.add(method.getName());
            }
            Collections.sort(methodList);
            for(String name: methodList){
                System.out.println(name);
            }
        }

    }
