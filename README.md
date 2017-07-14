# App description
1. Πακετάρισμα ενός Collection από strings, του οποίου η ακριβής υλοποίηση καθορίζεται στο runtime από τον χρήστη. Δημιουργία με χρήση reflection.
2. Δημιουργία ενός TextView με χρήση reflection, και προβολή αυτού αντι του EditText που χρησιμοποιούνταν αρχικά, κι εμφάνιση των περιοεχομένων του reflection.

## ProGuard usage
apk-debug size without proguard enabled:    1.6MB

apk-debug size with proguard enabled !opt:  896KB

apk-debug size with proguard enabled +opt:  876KB

## General proguard stuff

Η διαδικασία που ακολουθεί το proguard αποτελείται από τα 4 στάδια shrinking, optimization, obfuscation και preverification.
Στα configuration files συνήθως καθορίζονται entry points, τα οποία επιθυμούμε να παραμείνουν αναλλοίωτα. 
1. Κατά το shrinking step, το proguard ξεκινά να "αναλύει" με βάση τα entry points, και αναδρομικά καθορίζει το τι μπορεί να αφαιρεθεί και τι όχι.
2. Κατά το optimization step, γίνονται τα default optimizations του proguard. Μπορούμε να καθορίσουμε στο configuration file τι να μη γίνει, ή αν
θέλουμε, να μην πραγματοποιηθεί κανένα optimization.
3. Το obfuscation step είναι αρκετά χρήσιμο καθώς με την χρήση "τυχαίων" strings για τα ονόματα των κλάσεων/μελών τα οποία δεν είναι entry points. (reverse engineering)
4. Preverification

## Σχετικά με τη γλώσσα του
Γενικά ορίζονται σε configuration files κανόνες, οι οποίοι δηλώνουν τι πρέπει να κρατηθεί οπωσδήποτε (ή και όχι), ποιο step μπορεί να παραληφθεί, πόσα passes μπορούν να πραγματοποιηθούν,
ποια optimizations να μη γίνουν, κλπ.

Το proguard φαίνεται να λαμβάνει υπόψην του το reflection, τουλάχιστον σε "συνηθισμένες" περιπτώσεις, όπως χρήση forName(...). Γενικότερα όμως, στην περίπτωση που υπάρχει θέμα με
χρήση κάποιας κλάσης που καλείται με reflection, εφόσον ο προγραμματιστής ξέρει ποια θα είναι αυτή, μπορεί να προστεθεί το αντίστοιχο -keep rule στο configuration file (Στην περίπτωση
ανάλυσης, πιθανώς θα είναι γνωστό το ποια κλάση θα πρόκειται να χρησιμοποιηθεί, οπότε το tool που θα φτιάξουμε θα προσθέτει αυτόματα αντίστοιχους κανόνες). 

Η έξοδος του proguard, είναι τα εξής 4 αρχεία:
1. dump.txt που περιγράφει γενικά τη δομή των κλάσεων του παραγόμενου APK
2. mapping.txt που εμπεριέχει την αντιστοιχία ονομάτων μεταξύ αρχικών και obfuscated.
3. seeds.txt που περιέχει τις κλάσεις/μέλη που παραμείναν αναλλοίωτα
4. usage.txt που περιέχει τον κώδικα τον οποίο αφαιρέθηκε.


