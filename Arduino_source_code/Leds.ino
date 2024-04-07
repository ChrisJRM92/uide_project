void setup() {
  pinMode(2,OUTPUT);
  pinMode(3,OUTPUT);
  pinMode(4,OUTPUT);
  pinMode(5,OUTPUT);
  pinMode(6,OUTPUT);
  pinMode(7,OUTPUT);
  pinMode(8,OUTPUT);
  pinMode(9,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(11,OUTPUT);
  pinMode(12,OUTPUT);
  Serial.begin(9600);
}

void loop() {
  char datos = Serial.read();
  if(datos == 'a')digitalWrite(2,HIGH);
  if(datos == 'b')digitalWrite(2,LOW);
  
  if(datos == 'c')digitalWrite(3,HIGH);
  if(datos == 'd')digitalWrite(3,LOW);
  
  if(datos == 'e')digitalWrite(4,HIGH);
  if(datos == 'f')digitalWrite(4,LOW);
  
  if(datos == 'g')digitalWrite(5,HIGH);
  if(datos == 'h')digitalWrite(5,LOW);
  
  if(datos == 'i')digitalWrite(6,HIGH);
  if(datos == 'j')digitalWrite(6,LOW);
  
  if(datos == 'k')digitalWrite(7,HIGH);
  if(datos == 'l')digitalWrite(7,LOW);
  
  if(datos == 'm')digitalWrite(8,HIGH);
  if(datos == 'n')digitalWrite(8,LOW);
  
  if(datos == 'o')digitalWrite(9,HIGH);
  if(datos == 'p')digitalWrite(9,LOW);
  
  if(datos == 'q')digitalWrite(10,HIGH);
  if(datos == 'r')digitalWrite(10,LOW);
  
  if(datos == 's')digitalWrite(11,HIGH);
  if(datos == 't')digitalWrite(11,LOW);
  
  if(datos == 'u')digitalWrite(12,HIGH);
  if(datos == 'v')digitalWrite(12,LOW);
}
