## solitaire cipher

A cipher that is used to decrypt and encrypt messages using a key. <br>
The key is generated using a keyframe algorithm. <br>
The Keyframe algorithm uses a deck of cards. <br>
 
### Encoding
 
#### Steps 

1. Remove special characters and numbers from a given message <br>
e.g **Coding** **is** **fun!**, remove "!".
2. Capitalize and group message in fives and if the last group does not add up to five letters, add X's. <br>
e.g **CODIN** **GISFU** **NXXXX**.
3. Convert message into numbers. `A=1,B=2...Z=26`
4. Get the generated key and also convert it into numbers
5. Add key and message numbers, then convert the result numbers back to a string to get encoded message.
 
### Decoding
 
#### Steps

1. Get the given message (encoded message) and convert the given message into numbers
2. Get the generated key and also convert it into numbers
3. Subtract the generated key numbers from the message numbers and then convert the numbers to letters. <br>
Assuming the decoding was done on the message given above, we should get  **CODIN** **GISFU** **NXXXX**.
 
### Generating a key
 
A few things to note is that 
1. Ace card = 1, 2= 2, ...., Jack=11, Queens=12, Kings=13 and Joker(s)=53.
2. Starting with Clubs, then Diamonds, Hearts and lastly Spades we shall have the following values for each card in the card <br> 
`Clubs card = (Value of Card + 0)`, <br>
`Diamonds card = (Value of Card + 13)`, <br>
`Hearts card = (Value of Card + 26)`, <br>
`Spades card = (Value of Card + 39)`. <br>
 
#### Steps

1. Given a deck of cards, move `Joker A` one card below (swap with the card behind).
2. Move `Joker B` two cards below.
3. Triple cut the deck by swapping the cards above the top Joker with the cards below the bottom Joker.
4. Convert the bottom card on the deck to a number and then count off the cards on top of the deck and place them just above the bottom card <br> 
e.g if the bottom card was three of clubs, count off three cards from the top and place them above the three of clubs.
5. Now convert the top card to a number and again count off the cards on top of the deck starting with the card itself. The card you land on is the first key value.
6. Convert the card to a letter and then repeat from step 1 to step 5 to get the next key value.
