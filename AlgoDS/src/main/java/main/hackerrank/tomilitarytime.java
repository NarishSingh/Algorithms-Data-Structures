package main.hackerrank;

public class tomilitarytime {

    static String timeConversion(String s) {
        String amPm = s.substring(s.length() - 2); //AM/PM will always be at end
        String properMilTime = s.substring(0, s.length() - 2); //if fits certain criteria, just strip AM/PM

        if (s.substring(0, 2).equals("12")) {
            //edge case: first check if its 12
            switch (amPm) {
                case "AM": {
                    StringBuilder sb = new StringBuilder();
                    sb.append("00");
                    sb.append(s, 2, s.length() - 2);

                    return sb.toString();
                }
                case "PM": {
                    return properMilTime;
                }
                default: {
//                    throw new IllegalAccessException("Time improperly formatted");
                    return null; //never happens but can't throw exception
                }
            }
        } else if (amPm.equals("AM")) {
            //if AM, just strip and return
            return properMilTime;
        } else {
            //if not 12 or AM, add 12 to hr and strip PM
            int hr = Integer.parseInt(s.substring(0, 2));
            hr += 12;

            StringBuilder sb = new StringBuilder();
            sb.append(hr);
            sb.append(s, 2, s.length() - 2);

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String stdTime = "07:05:45AM";
        String stdTime2 = "07:05:45PM";
        String stdTime3 = "12:05:45AM";
        String stdTime4 = "12:05:45PM";

        System.out.println(timeConversion(stdTime));
        System.out.println(timeConversion(stdTime2));
        System.out.println(timeConversion(stdTime3));
        System.out.println(timeConversion(stdTime4));
    }
}
