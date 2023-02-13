² int boutonStatut;
int ran;
int sos;
void setup()
{
  boutonStatut=0;
  for(int i=2;i<9;i++)
  {
    pinMode(i, OUTPUT);
  }
  sos=0;
}

void loop()
{
  
  if(digitalRead(10) == HIGH)
  {
    boutonStatut=1;
  }
  if (boutonStatut==1)
  {
    for(int t = 2;t<9;t++)
    {
      digitalWrite(t, HIGH);
      delay(800);
      digitalWrite(t, LOW);
    }
    tone(9,100,3060);
    for(int g = 0;g<20;g++)
    {
      for(int t = 0;t<9;t++)
      {
        digitalWrite(t, HIGH);
        delay(17);
        digitalWrite(t, LOW);
      }
      
    }
    for(int r = 0;r<700;r++) 
    {
      for(int t = 2;t<9;t++)
      {
        digitalWrite(t, HIGH);
      }
      ran = random (500, 1000);
      tone(9,ran,5);
      delay(5);
      for(int t = 2;t<9;t++)
      {
        digitalWrite(t, LOW);
      }
    }
    tone(9,0,10);
    boutonStatut=0;
    for(int r = 0;r<2400;r++)
    {
      delay(50);
      if(digitalRead(10) == HIGH)
      {
        boutonStatut=1;
      }
    }
    while(boutonStatut==0)
    {
      if(digitalRead(10) == HIGH)
      {
        boutonStatut=1;
      }
      if(sos==99)
      {
        boutonStatut=1;
      }
      tone(9,100,50);
      for(int t = 2;t<9;t++)
      {
        if(digitalRead(10) == HIGH)
        {
          boutonStatut=1;
        }
        digitalWrite(t, HIGH);
        delay(200);
        digitalWrite(t, LOW);
      }
      sos++; 
    }
    sos=0;
    boutonStatut=0;
  }
}  
