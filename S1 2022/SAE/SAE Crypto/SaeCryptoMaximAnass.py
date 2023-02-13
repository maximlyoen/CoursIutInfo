from pickle import FALSE
import random
import math


# Exponentiation modulaire
def PModulaire(a, b, n):
    r = 1
    while b>0:
        if b&1==0:
            b = b>>1
        else:
            r = (r*a)%n
            b = (b-1)>>1
        a = (a*a)%n
    return r


# Permet de calculé le pgcd
def pgcd(a,b):
    while a!=b: 
        d=abs(b-a) 
        b=a 
        a=d
    if (d < 0):
        return -d
    else :
        return d


# Permet de faire algorithme de bezout
def bezout(a, b):
    s, t, u, v = 1, 0, 0, 1
    while b != 0:
        q = a // b
        a, s, t, b, u, v = b, u, v, a - q * b, s - q * u, t - q * v
    return (s)


# Permet de testé si un nombre est premier
def test_premier(n):
    for i in range(2, int(math.sqrt(n))+1):
        if (n % i) == 0:
            return False
    return True


# Genere les clés
def generationCle(p,q):
    e = 0
    if(test_premier(p) and test_premier(q)):
        omegaN=(p-1)*(q-1)
        for i in range(2, omegaN):
                var_test = random.randint(2, omegaN-1)
                if(pgcd(var_test, omegaN) == 1):
                    e = var_test
                    break
        d = bezout(e, omegaN)
        while(d < 2):
            d += omegaN
        return e, d
    else:
        print("Nombre pas premier")


#Genere 2 nombre premier pour Alice
def GenerationPremierEntreEuxAliceBob():
    nb_premier = []
    for i in range(100000, 1000000+1):
        if(test_premier(i) == True):
            nb_premier.append(i)
        if(len(nb_premier) > 1000):
            break
    nb1 = nb_premier[random.randint(0, len(nb_premier))-1]
    nb2 = nb_premier[random.randint(0, len(nb_premier)-1)]
    return nb1, nb2


#Genere 2 nombre premier pour Ca
def GenerationPremierEntreEuxCa():
    nb_premier = []
    for i in range(100000, 1000000+1):
        if(test_premier(i) == True):
            nb_premier.append(i)
    if(len(nb_premier) == 0):
        print("\n Dans cette intervalle il n'y a pas de nombres premiers \n ")
    nb1 = nb_premier[random.randint(0, len(nb_premier))-1]
    nb2 = nb_premier[random.randint(0, len(nb_premier)-1)]
    return nb1, nb2


#Permet de faire le chiffrement rsa
def chiffrement_RSA(a,b,c):
    return PModulaire(a,b,c)


#Permet de faire le dechiffrement rsa
def dechiffrement_RSA(a,b,c):
    return PModulaire(a,b,c)


#Permet de faire le hachage
def hachage(a):
    return a % 2

def main():
    #Creation de cle
    print("Debut génération Maxim Lyoen Anass Kerchaoui \n")
    print("Création cle Alice")
    pAlice , qAlice = GenerationPremierEntreEuxAliceBob()
    print("pAlice = "+str(pAlice)+" qAlice = "+str(qAlice)+" sont premier entre eux")
    nAlice = pAlice * qAlice
    eAlice,dAlice=generationCle(pAlice,qAlice)
    print("nAlice = "+str(nAlice)+" eAlice = "+str(eAlice)+" pAlice = "+str(pAlice) +"\n")
    print("Création cle Ca")
    pCa , qCa = GenerationPremierEntreEuxCa()
    print("pCa = "+str(pCa)+" qCa = "+str(qCa) +" sont premier entre eux")
    nCa = pCa * qCa
    eCa,dCa=generationCle(pCa,qCa)
    print("nCa = "+str(nCa)+" eCa = "+str(eCa)+" pCa = "+str(pCa)+"\n")
    print("Création cle Bob")
    pBob , qBob = GenerationPremierEntreEuxAliceBob()
    print("pBob = "+str(pBob)+" qBob = "+str(qBob)+" sont premier entre eux")
    nBob = pBob * qBob
    eBob,dBob=generationCle(pBob,qBob)
    print("nBob = "+str(nBob)+" eBob= "+str(eBob)+" pBob = "+str(pBob)+"\n")
    

    #Scrypt
    print("Debut du srypt \n")
    print("----------alice crypt le message----------")
    signature_eAlice_Haché = hachage(eAlice)
    try:
        assert(signature_eAlice_Haché < nAlice)
    except AssertionError:
        print("Erreur : La valeur de la signature est plus grande que nAlice")
    else:
        print("     la signature hachée est "+ str(signature_eAlice_Haché))
        signature_crypter = chiffrement_RSA(signature_eAlice_Haché,dAlice,nAlice)
        print("     La signature de alice crypter est "+ str(signature_crypter))
        concat_message = str(eAlice) + str(signature_crypter)
        print("     le message contat est " + concat_message)
        try:
            assert(int(concat_message) < nCa)
        except AssertionError:
            print("Erreur : La valeur de la signature est plus grande que nCa")
        else:
            concat_message_crypté = chiffrement_RSA(int(concat_message),eCa,nCa)
            print("     le message entiererment crypté est " + str(concat_message_crypté) + "\n")


            #Dechiffrement
            print("----------le ca dechiffre le message----------")
            message_contat_dechiffrer = dechiffrement_RSA(concat_message_crypté,dCa,nCa)
            print("     le resultat du dechiffrement est " + str(message_contat_dechiffrer))
            empreinte= str(message_contat_dechiffrer)[-len(str(signature_crypter)):]
            print("     L'empreinte chiffré est "+ empreinte)
            empreinte_dechiffrer= dechiffrement_RSA(int(empreinte),eAlice,nAlice)
            print("     empreinte dechiffré est "+ str(empreinte_dechiffrer) + "\n")


            #Verification
            print("----------Verification----------")
            try:
                assert(empreinte_dechiffrer == hachage(eAlice))
            except AssertionError:
                print("Erreur : Il ne s'agit pas des même valeur apres dechiffrement")
            else:
                try:
                    assert(empreinte_dechiffrer < nCa)
                except AssertionError:
                    print("Erreur : La valeur de l'empreinte déchiffrer est plus grande que nCA")
                print("     Il sagit de la meme empreinte" + "\n")
                print("----------generation du certificat----------")
                try:
                    assert(empreinte_dechiffrer< nCa)
                except AssertionError:
                    print("Erreur : La valeur de empreinte est trop petite donc cryptage rsa impossible")
                else:
                    chiffrement_ca = chiffrement_RSA(empreinte_dechiffrer, dCa, nCa)
                    bob_dechiffrement= dechiffrement_RSA(chiffrement_ca,eCa,nCa)
                    try:
                        assert(bob_dechiffrement == hachage(eAlice))
                    except AssertionError:
                        print("Erreur : La valeur de l'empreinte déchiffrer est plus grande que nCA")
                    else:
                        print("     bob a recu le message sans probleme \n")

main()