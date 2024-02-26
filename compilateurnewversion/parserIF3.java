package compilateurnewversion;

import java.util.Stack;

public class parserIF3 {


public String[] LRGS = {
"S'->S",
"S->void main ( ) { P }",
"P->D ; I ;",
"D->T id",
"D->D ; D ;",
"T->int",
"T->float",
"T->bool",
"T->string",
"T->int [ nb ]",
"I->id := Ea",
"I->if ( Ec ) { I }",
"I->if ( Ec ) { I } else { I }",
"I->for ( Ef ) { I }",
"I->scanf ( F )",
"I->puts ( ch )",
"I->I ; I ;",
"Ea->V",
"Ea->ch",
"Ea->V + V",
"Ea->V - V",
"Ea->V / V",
"Ea->V * V",
"V->id",
"V->nb",
"Ec->V > V",
"Ec->V = V",
"Ec->V >= V",
"Ef->int id := nb ; id <= nb ; id ++",
"F->' % F1 ' , & id",
"F1->d",
"F1->f",
"F1->s"
   		};


public String[][] tableSLR = {
    {"etat/VT", "void", "main", "(", ")", "{", "}", ";", "id", "int", "float", "bool", "string", "[", "nb", "]", ":=", "if", "else", "for", "scanf", "puts", "ch", "+", "-", "/", "*", ">", "==", ">=", "<=", "++", "'", "%", ",", "&", "d", "f", "s", "$", "S'", "S", "P", "D", "T", "I", "Ea", "V", "Ec", "Ef", "F", "F1"},
    {"0", "s2", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "1", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"1", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "ACC", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"2", "err", "s3", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"3", "err", "err", "s4", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"4", "err", "err", "err", "s5", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"5", "err", "err", "err", "err", "s6", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"6", "err", "err", "err", "err", "err", "err", "err", "err", "s10", "s11", "s12", "s13", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "7", "8", "9", "err", "err", "err", "err", "err", "err", "err"},
    {"7", "err", "err", "err", "err", "err", "s14", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"8", "err", "err", "err", "err", "err", "err", "s15", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"9", "err", "err", "err", "err", "err", "err", "err", "s16", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"10", "err", "err", "err", "err", "err", "err", "err", "r5", "err", "err", "err", "err", "s17", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"11", "err", "err", "err", "err", "err", "err", "err", "r6", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"12", "err", "err", "err", "err", "err", "err", "err", "r7", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"13", "err", "err", "err", "err", "err", "err", "err", "r8", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"14", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r1", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"15", "err", "err", "err", "err", "err", "err", "err", "s20", "s10", "s11", "s12", "s13", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "19", "9", "18", "err", "err", "err", "err", "err", "err"},
    {"16", "err", "err", "err", "err", "err", "err", "r3", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"17", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s25", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"18", "err", "err", "err", "err", "err", "err", "s26", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"19", "err", "err", "err", "err", "err", "err", "s27", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"20", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s28", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"21", "err", "err", "s29", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"22", "err", "err", "s30", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"23", "err", "err", "s31", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"24", "err", "err", "s32", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"25", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s33", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"26", "err", "err", "err", "err", "err", "r2", "err", "s20", "err", "err", "err", "err", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "34", "err", "err", "err", "err", "err", "err"},
    {"27", "err", "err", "err", "err", "err", "err", "r4", "err", "s10", "s11", "s12", "s13", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "19", "9", "err", "err", "err", "err", "err", "err", "err"},
    {"28", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "s37", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "35", "36", "err", "err", "err", "err"},
    {"29", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "41", "40", "err", "err", "err"},
    {"30", "err", "err", "err", "err", "err", "err", "err", "err", "s43", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "42", "err", "err"},
    {"31", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s45", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "44", "err"},
    {"32", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s46", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"33", "err", "err", "err", "err", "err", "err", "err", "r9", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"34", "err", "err", "err", "err", "err", "err", "s47", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"35", "err", "err", "err", "err", "err", "r10", "r10", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"36", "err", "err", "err", "err", "err", "r17", "r17", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s48", "s49", "s50", "s51", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"37", "err", "err", "err", "err", "err", "r18", "r18", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"38", "err", "err", "err", "r23", "err", "r23", "r23", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r23", "r23", "r23", "r23", "r23", "r23", "r23", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"39", "err", "err", "err", "r24", "err", "r24", "r24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r24", "r24", "r24", "r24", "r24", "r24", "r24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"40", "err", "err", "err", "s52", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"41", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s53", "s54", "s55", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"42", "err", "err", "err", "s56", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"43", "err", "err", "err", "err", "err", "err", "err", "s57", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"44", "err", "err", "err", "s58", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"45", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s59", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"46", "err", "err", "err", "s60", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"47", "err", "err", "err", "err", "err", "r16", "r16", "s20", "err", "err", "err", "err", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "34", "err", "err", "err", "err", "err", "err"},
    {"48", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "61", "err", "err", "err", "err"},
    {"49", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "62", "err", "err", "err", "err"},
    {"50", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "63", "err", "err", "err", "err"},
    {"51", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "64", "err", "err", "err", "err"},
    {"52", "err", "err", "err", "err", "s65", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"53", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "66", "err", "err", "err", "err"},
    {"54", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "67", "err", "err", "err", "err"},
    {"55", "err", "err", "err", "err", "err", "err", "err", "s38", "err", "err", "err", "err", "err", "s39", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "68", "err", "err", "err", "err"},
    {"56", "err", "err", "err", "err", "s69", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"57", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s70", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"58", "err", "err", "err", "err", "err", "r14", "r14", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"59", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s72", "s73", "s74", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "71"},
    {"60", "err", "err", "err", "err", "err", "r15", "r15", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"61", "err", "err", "err", "err", "err", "r19", "r19", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"62", "err", "err", "err", "err", "err", "r20", "r20", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"63", "err", "err", "err", "err", "err", "r21", "r21", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"64", "err", "err", "err", "err", "err", "r22", "r22", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"65", "err", "err", "err", "err", "err", "err", "err", "s20", "err", "err", "err", "err", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "75", "err", "err", "err", "err", "err", "err"},
    {"66", "err", "err", "err", "r25", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"67", "err", "err", "err", "r26", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"68", "err", "err", "err", "r27", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"69", "err", "err", "err", "err", "err", "err", "err", "s20", "err", "err", "err", "err", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "76", "err", "err", "err", "err", "err", "err"},
    {"70", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s77", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"71", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s78", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"72", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r30", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"73", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r31", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"74", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "r32", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"75", "err", "err", "err", "err", "err", "s79", "s80", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"76", "err", "err", "err", "err", "err", "s81", "s80", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"77", "err", "err", "err", "err", "err", "err", "s82", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"78", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s83", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"79", "err", "err", "err", "err", "err", "r11", "r11", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s84", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"80", "err", "err", "err", "err", "err", "err", "err", "s20", "err", "err", "err", "err", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "34", "err", "err", "err", "err", "err", "err"},
    {"81", "err", "err", "err", "err", "err", "r13", "r13", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"82", "err", "err", "err", "err", "err", "err", "err", "s85", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"83", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s86", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"84", "err", "err", "err", "err", "s87", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"85", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s88", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"86", "err", "err", "err", "err", "err", "err", "err", "s89", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"87", "err", "err", "err", "err", "err", "err", "err", "s20", "err", "err", "err", "err", "err", "err", "err", "err", "s21", "err", "s22", "s23", "s24", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "90", "err", "err", "err", "err", "err", "err"},
    {"88", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s91", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"89", "err", "err", "err", "r29", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"90", "err", "err", "err", "err", "err", "s92", "s80", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"91", "err", "err", "err", "err", "err", "err", "s93", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"92", "err", "err", "err", "err", "err", "r12", "r12", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"93", "err", "err", "err", "err", "err", "err", "err", "s94", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"94", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "s95", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},
    {"95", "err", "err", "err", "r28", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err", "err"},};
        
    public Stack<String> stackState = new Stack<>();
    
    
    public Stack<String> analyse = new Stack<>();
    
    public Stack<String> stackSymbol = new Stack<>();
    private String ch[]= {"a", "b", "b", "a","$"};
    public String strInput ;
    
   
    public String action = "";
    
    
    
    int index = 0;
    public parserIF3( String[] ch){
        this.ch=ch;
    }
   
    public void analyzeSLnew() {
    	
        action = "";
        index = 0;
       
        analyse.push("0");
        
       
        System.out.println("********pile     Entrée   Action			   ");
        this.AfficherSLR();
    
       while(index<ch.length) 
        
        {
              
            String s = analyse.peek();
            
            String act=Action(s,ch[index]);
          
            if (Action(s,ch[index]).charAt(0) == 's') {
                   	
                           
                analyse.push(ch[index]);
                analyse.push(Action(s, ch[index]).substring(1));
               
                              
              
                index++;
                action = "shift";
                
                AfficherSLR();
            }
            // Réduction
            else if (Action(s,ch[index]).charAt(0) == 'r') {
                //
                String str = LRGS[Integer.parseInt(Action(s, ch[index]).substring(1))];
                int pos= str.indexOf('>');
               
                String tabparties[]= str.split("->");
                
                
                String Partiegauche=tabparties[0];
               // System.out.println("Partiegauche"+Partiegauche); 
                
                String Partiedroite=tabparties[1];
                //System.out.println("Partiedroite"+Partiedroite); 
                
                String tabtoken[]= Partiedroite.split(" ");

                int taillepile= tabtoken.length*2 ;
               
               
                for (int i = 0; i < taillepile; i++) {

                    analyse.pop();
                    
                }
                String sommetpile = analyse.peek();
                analyse.push(Partiegauche);
                //String tetesucc = analyse.peek();
                
                analyse.push(Action(sommetpile, Partiegauche));
                
               
                action = "reduce:" + str;
                AfficherSLR();
            } 
            //acceptation
            else if (Action(s,ch[index]) == "ACC")
            	{
            	System.out.println("analyze SLR successfully"); 
            	break;}
            	
            else
            	//erreur
            	{
            	
            	System.out.println("texterreur"+Action(s,ch[index])+s+ch[index]+index); 
            	System.out.println("analyze SLR failled"); 
        	break;
            	}
               
        }
        
    }
  
   
    
    public void analyzeSLnew(String []tt) {
    	
        action = "";
        index = 0;
       
        analyse.push("0");
        
       
        System.out.println("********pile     	    Entrée            Action***********");
        this.AfficherSLRnew(tt);
    
       while(index<tt.length) 
        
        {
        	
    	   
          //  String s = stackState.peek();
            
            String s = analyse.peek();
            
            String act=Action(s,tt[index]);
          
            if (Action(s,tt[index]).charAt(0) == 's') {
            	
            	
                //stackState.push(Action(s, ch[index]).substring(1));
                //stackSymbol.push(ch[index]);
                
                analyse.push(tt[index]);
                analyse.push(Action(s, tt[index]).substring(1));
               
                
                
              
                index++;
                action = "shift ";
                
                AfficherSLRnew(tt);
            }
            // Réduction
            else if (Action(s,tt[index]).charAt(0) == 'r') {
                //
                String str = LRGS[Integer.parseInt(Action(s, tt[index]).substring(1)) - 1];
                int pos= str.indexOf('>');
               
                String tabparties[]= str.split("->");
                
                
                String Partiegauche=tabparties[0];
               // System.out.println("Partiegauche"+Partiegauche); 
                
                String Partiedroite=tabparties[1];
                //System.out.println("Partiedroite"+Partiedroite); 
                
                String tabtoken[]= Partiedroite.split(" ");
                int taillepile= tabtoken.length +tabtoken.length;
               
               
                for (int i = 0; i < taillepile; i++) {
                	
                  
                    
                    analyse.pop();
                    
                }
                String sommetpile = analyse.peek();
                analyse.push(Partiegauche);
                String tetesucc = analyse.peek();
                
                analyse.push(Action(sommetpile, Partiegauche));
                
               
                action = "reduce:" + str;
                AfficherSLRnew(tt);
            } 
            //acceptation
            else if (Action(s,tt[index]) == "ACC")
            	{
            	System.out.println("analyze SLR successfully"); 
            	break;}
            	
            else
            	//erreur
            	{
            	
            	//System.out.println("texterreur"+Action(s,ch[index])+s+ch[index]+index); 
            	System.out.println("analyze SLR failled"); 
        	break;
            	}
               
        }
        
    }
    
    
    
    
    public String Action(String s, String a) {
        for (int i = 1; i <95 ; i++)
            if (tableSLR[i][0].equals(s))
                for (int j = 1; j <51; j++)
                    if (tableSLR[0][j].equals(a))
                        return tableSLR[i][j];
        return "err";
    }

    
 


    public void AfficherSLR() {
        //  SLR
    	
    	
    	String ss= "-------";
    	String ss1= "-------";
    	 int taillepile=analyse.size();
    	int taillepilediv2= taillepile /2;
         for(int i=0;i<taillepilediv2;i++)
     		ss=ss + "-------" ;
         int tailleinput=ch.length;
         for(int i=0;i<tailleinput;i++)
     		ss1=ss1 + "-------" ;
    	
    	
    	
        
       
        strInput="";
        for(int i=index; i<ch.length;i++)
        	strInput= strInput+ ch[i];
       
        System.out.printf("%s", analyse + ss1);
        System.out.printf("%s", strInput+ ss);
        System.out.printf("%s", action);
        System.out.println();
    }

    public void AfficherSLRnew(String []tt) {
        //  SLR
    	
    	
    	String ss= "-------";
    	String ss1= "-------";
    	 int taillepile=analyse.size();
    	int taillepilediv2= taillepile /2;
         for(int i=0;i<taillepilediv2;i++)
     		ss=ss + "-------" ;
         int tailleinput=tt.length;
         for(int i=0;i<tailleinput;i++)
     		ss1=ss1 + "-------" ;
    	
    	
    	
        
       
        strInput="";
        for(int i=index; i<tt.length;i++)
        	strInput= strInput+ tt[i];
       
        System.out.printf("%s", analyse + ss1);
        System.out.printf("%s", strInput+ ss);
        System.out.printf("%s", action);
        System.out.println();
    }

    public void ouput() {
        
        
        System.out.println("**********Tableau SLR¨********");

        for (int i = 0; i < 11 ; i++) {
            for (int j = 0; j <7; j++) {
                System.out.printf("%6s", tableSLR[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**********Fin tableau SLR********");

    }   

}





