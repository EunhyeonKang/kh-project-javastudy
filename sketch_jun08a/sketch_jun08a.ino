int red=6;
int green=8;
int blue=10;

void setup() {
  // put your setup code here, to run once:
  pinMode(red,OUTPUT);  
  pinMode(green,OUTPUT);  
  pinMode(blue,OUTPUT);  
}

void loop() {
  // put your main code here, to run repeatedly:
  while(true){
    digitalWrite(red,HIGH);  
    delay(5000); 
    digitalWrite(red,HIGH);
    digitalWrite(green,HIGH); 
    delay(2000); 
    digitalWrite(red,LOW);
    digitalWrite(green,LOW); 
    digitalWrite(blue,HIGH);
    delay(10000);  
    digitalWrite(blue,LOW);
    delay(1000);
  }  
}
