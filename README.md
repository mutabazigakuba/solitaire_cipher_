Build [![CircleCI](https://circleci.com/gh/mutabazigakuba/solitaire_cipher_challenge_MR.svg?style=svg&circle-token=568bf02ef81448d834a371905b6992f32a2dccc9)](https://circleci.com/gh/mutabazigakuba/solitaire_cipher_challenge_MR)

# solitaire cipher
A cipher that is used to decrpyt and encrypt messages using a key generated using keyframe algorithm. The Keyframe algorithm uses a deck of cards to generate the key.
 
 ### Encoding
 
 1. Remove special characters and numbers from given message e.g **Coding** **is** **fun!**, remove "!".
 2. Capitalize and group message in fives and if the last group does not add upto to five letters, add x's, e.g **CODIN** **GISFU** **NXXXX**.
 3. Convert message into numbers. `A=1,B=2...Z=26`
 4. Get the generated key and also convert it into numbers
 5. Add key and message numbers, then converted result to string to get encoded message.
 
 ### Decoding
 
 1. Get the given message (encoded message) and convert the given message into numbers
 2. Get the generated key and also convert it into numbers
 3. Substract the generated key numbers from the message (encoded message) numbers and then convert the numbers to letters.
 If the decoding was done on the message given above, we should get  **CODIN** **GISFU** **NXXXX**.
 
 ### Generating a key
 
 A few things to note is that Ace card = 1, 2= 2, ...., Jack=11, Queens=12, Kings=13 and Joker(s)=53. 
 And also `Clubs card = (Value of Card + 0)`, `Diamonds card = (Value of Card + 13)`, `Hearts card = (Value of Card + 26)`, `Spades card = (Value of Card + 39)`.
 
 1. Given a deck of cards, move Joker A one card below (Just below the card at it's bottom)
 2. Move Joker B two cards below
 3. Triple cut the deck by swapping the cards above Joker B with the cards below Joker A if Joker B is above Joker A. Leave the cards between both Jokers unchanged or untouched.
 4. Convert the last card on the deck to a numeber and then count off the cards on top of the deck and place them just above the last card e.g if the last card was three of clubs, count off three cards and place them above the three of clubs.
 5. Now convert the top card to a number and again count off the cards on top of the deck. The card you land on is the first key value.
 6. Convert the card to a letter and then repeat from step 1 to step 4 to get the next key value.
