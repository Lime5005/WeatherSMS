# WeatherSMS

A funny app to send yourself a SMS everyday about weather and a positive message, as you want!
Example:
Good Morning! Paris🌧  🌡+12°C
It's Wednesday, December 21 🌘
🤔 Remember: Mistakes don't make you less capable 👍  
Today's Quote: You must welcome change as the rule but not as your ruler.  
-Denis Waitley  
✨ Have a Great Day ✨

## To run the application

1, Download the app, then add plugin "Azure Toolkit for Intellij".

2, Tools -> Azure sign in -> sign in with your account.

3, Tools -> Select subscription -> select your Azure subscription.

4, Add this class with your own credentials from Twilio:
```
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZoneId;

public class Config {
    public static final ZoneId MY_TIMEZONE = ZoneId.of("Europe/Paris");
    public static final String WTTR_LOCATION = "Paris";
    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static final String TWILIO_ACCOUNT_SID = "<ur_own_TWILIO_ACCOUNT_SID>";
    public static final String TWILIO_AUTH_TOKEN = "<ur_own_TWILIO_AUTH_TOKEN>";

    public static final String TWILIO_PHONE_NUMBER = "<ur_own_TWILIO_PHONE_NUMBER>";
    public static final String MY_PHONE_NUMBER = "<ur_own_PHONE_NUMBER>";
}
```
5, Make sure your Function App instance is running in Azure.

6, Test and run it.

## Pre-request

Create an account in [Azure](https://portal.azure.com/#home).

Create an account in [Twilio](https://console.twilio.com/).


