#include <LiquidCrystal.h>
#include <EEPROM.h>

void writeString(char add,String data);
String readString(char add);

String inputString = "";         // a String to hold incoming data
bool isReadString = false;  // whether the string is complete
const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

void setup() {
  // put your setup code here, to run once:
  lcd.begin(16, 2); // init LCD
  
  // reserve 200 bytes for the inputString:
  inputString.reserve(200);

  Serial.begin(9600);

  String data = "No data is written in EEPROM";
  if(EEPROM.read(0) != 0xFF){ // read data if available in EEPROM
    data = readString(0);
  }
  lcd.print(data);
  Serial.println(data);
  delay(10);
}

void loop() {
  if(isReadString){
    writeString(0, inputString);
    lcd.print(inputString);
    Serial.println(inputString);
    inputString = "";
    isReadString = false;
  }
}

void writeString(char address, String data){
  int _size = data.length();
  int i;
  for(i=0; i<_size; i++){
    EEPROM.write(address+i, data[i]);
  }
  EEPROM.write(address + _size, '\0');   //Add termination null character for String Data
}


String readString(char address){
  char data[100]; //Max 100 Bytes
  int length=0;
  unsigned char tempChar;
  tempChar = EEPROM.read(address);
  while(tempChar != '\0' && length<500){       //Read until null character
    tempChar = EEPROM.read(address+length);
    data[length] = tempChar;
    length++;
  }
  data[length]='\0';
  return String(data);
}

void serialEvent() {
  while (Serial.available()) {
    // get the new byte:
    char inChar = (char)Serial.read();
    // add it to the inputString:
    inputString += inChar;
    // if the incoming character is a newline, set a flag so the main loop can
    // do something about it:
    if (inChar == '\n') {
      isReadString = true;
    }
  }
}
