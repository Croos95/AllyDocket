// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: src/Lexer.flex

import compilerTools.Token;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Lexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\1\1\1\4\22\0\1\1"+
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\2\10"+
    "\1\14\1\15\1\10\1\16\1\17\1\20\1\21\1\22"+
    "\10\23\1\0\1\10\1\24\1\25\1\26\2\0\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
    "\2\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\1\50\1\51\1\52\1\53\1\40\1\54\1\55\1\56"+
    "\1\10\1\0\1\10\1\0\1\57\1\0\32\40\1\10"+
    "\1\60\1\10\7\0\1\3\73\0\1\40\7\0\1\40"+
    "\3\0\1\40\3\0\1\40\1\0\1\40\6\0\1\40"+
    "\1\0\1\40\4\0\1\40\7\0\1\40\3\0\1\40"+
    "\3\0\1\40\1\0\1\40\6\0\1\40\1\0\1\40"+
    "\u012b\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\2\3\1\1\1\3\1\1\2\3"+
    "\4\1\2\4\21\1\1\3\1\1\3\0\1\5\1\0"+
    "\1\3\1\0\12\1\1\6\17\1\1\0\4\2\1\0"+
    "\2\7\2\1\1\6\25\1\1\6\1\10\54\1\1\11"+
    "\5\1\1\12\11\1\1\13\6\1\1\14\4\1\1\6"+
    "\15\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[189];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\61\0\142\0\223\0\304\0\365\0\61"+
    "\0\u0126\0\u0157\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d"+
    "\0\u02ae\0\u02df\0\u0310\0\u0341\0\u0372\0\u03a3\0\u03d4\0\u0405"+
    "\0\u0436\0\u0467\0\u0498\0\u04c9\0\u04fa\0\u052b\0\u055c\0\u058d"+
    "\0\u05be\0\u05ef\0\u0467\0\u0620\0\u0651\0\u0682\0\u06b3\0\u06e4"+
    "\0\u0715\0\u0746\0\u0777\0\u07a8\0\u07d9\0\u080a\0\u083b\0\u086c"+
    "\0\u089d\0\u08ce\0\u08ff\0\u0930\0\u0961\0\u0467\0\u0992\0\u09c3"+
    "\0\u09f4\0\u0a25\0\u0a56\0\u0a87\0\u0ab8\0\u0ae9\0\u0b1a\0\u0b4b"+
    "\0\u0b7c\0\u0bad\0\u0bde\0\u0c0f\0\u0c40\0\u0c71\0\u0746\0\u0715"+
    "\0\u0ca2\0\u0cd3\0\u0d04\0\61\0\u0d35\0\u0d66\0\u0d97\0\u0dc8"+
    "\0\u0df9\0\u0e2a\0\u0e5b\0\u0e8c\0\u0ebd\0\u0eee\0\u0f1f\0\u0f50"+
    "\0\u0f81\0\u0fb2\0\u0fe3\0\u1014\0\u1045\0\u1076\0\u10a7\0\u10d8"+
    "\0\u1109\0\u113a\0\u116b\0\u119c\0\u11cd\0\u11fe\0\61\0\u122f"+
    "\0\u1260\0\u1291\0\u12c2\0\u12f3\0\u1324\0\u1355\0\u1386\0\u13b7"+
    "\0\u13e8\0\u1419\0\u144a\0\u147b\0\u14ac\0\u14dd\0\u150e\0\u153f"+
    "\0\u1570\0\u15a1\0\u15d2\0\u1603\0\u1634\0\u1665\0\u1696\0\u16c7"+
    "\0\u16f8\0\u1729\0\u175a\0\u178b\0\u17bc\0\u17ed\0\u181e\0\u184f"+
    "\0\u1880\0\u18b1\0\u18e2\0\u1913\0\u1944\0\u1975\0\u19a6\0\u19d7"+
    "\0\u1a08\0\u1a39\0\u1a6a\0\u0467\0\u1a9b\0\u1acc\0\u1afd\0\u1b2e"+
    "\0\u1b5f\0\u0467\0\u1b90\0\u1bc1\0\u1bf2\0\u1c23\0\u1c54\0\u1c85"+
    "\0\u1cb6\0\u1ce7\0\u1d18\0\u0467\0\u1d49\0\u1d7a\0\u1dab\0\u1ddc"+
    "\0\u1e0d\0\u1e3e\0\u0467\0\u1e6f\0\u1ea0\0\u1ed1\0\u1f02\0\u1f33"+
    "\0\u1f64\0\u1f95\0\u1fc6\0\u1ff7\0\u2028\0\u2059\0\u208a\0\u20bb"+
    "\0\u20ec\0\u211d\0\u214e\0\u217f\0\u21b0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[189];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\10\1\17"+
    "\1\20\2\21\1\22\1\5\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\2\32\1\33\1\32\1\34\1\35"+
    "\2\32\1\36\1\32\1\37\1\40\1\41\1\32\1\42"+
    "\3\32\1\43\1\44\63\0\1\3\103\0\1\10\50\0"+
    "\2\45\2\0\1\46\2\47\64\0\31\50\12\0\1\10"+
    "\61\0\1\10\63\0\2\10\56\0\1\10\61\0\1\10"+
    "\4\0\2\21\53\0\1\10\3\0\2\21\35\0\20\51"+
    "\1\52\40\51\17\0\1\53\60\0\1\53\1\0\3\21"+
    "\61\0\2\10\60\0\2\10\53\0\3\32\3\0\1\32"+
    "\1\54\16\32\1\55\10\32\22\0\3\32\3\0\15\32"+
    "\1\56\13\32\22\0\3\32\3\0\15\32\1\57\13\32"+
    "\22\0\3\32\3\0\4\32\1\60\3\32\1\61\20\32"+
    "\22\0\3\32\3\0\14\32\1\62\10\32\1\63\3\32"+
    "\22\0\3\32\3\0\1\64\30\32\22\0\3\32\3\0"+
    "\31\32\22\0\3\32\3\0\6\32\1\65\22\32\22\0"+
    "\3\32\3\0\14\32\1\66\1\67\13\32\22\0\3\32"+
    "\3\0\1\70\1\32\1\71\1\32\1\72\3\32\1\73"+
    "\4\32\1\74\5\32\1\75\5\32\22\0\3\32\3\0"+
    "\15\32\1\76\2\32\1\77\10\32\22\0\3\32\3\0"+
    "\1\100\3\32\1\101\24\32\22\0\3\32\3\0\4\32"+
    "\1\102\3\32\1\66\12\32\1\103\5\32\22\0\3\32"+
    "\3\0\1\102\3\32\1\104\24\32\22\0\3\32\3\0"+
    "\1\105\30\32\61\0\1\10\22\0\2\47\64\0\31\106"+
    "\22\0\3\47\3\0\31\106\22\0\3\50\3\0\31\50"+
    "\1\0\20\51\1\3\40\51\2\107\1\110\1\107\1\111"+
    "\13\107\1\112\40\107\15\0\2\113\2\0\1\114\2\115"+
    "\56\0\3\32\3\0\21\32\1\66\7\32\22\0\3\32"+
    "\3\0\2\32\1\116\26\32\22\0\3\32\3\0\15\32"+
    "\1\117\13\32\22\0\3\32\3\0\21\32\1\120\7\32"+
    "\22\0\3\32\3\0\2\32\1\121\16\32\1\122\7\32"+
    "\22\0\3\32\3\0\5\32\1\123\16\32\1\124\4\32"+
    "\22\0\3\32\3\0\22\32\1\125\6\32\22\0\3\32"+
    "\3\0\16\32\1\66\12\32\22\0\3\32\3\0\2\32"+
    "\1\126\26\32\22\0\3\32\3\0\23\32\1\127\5\32"+
    "\22\0\3\32\3\0\6\32\1\130\22\32\22\0\3\32"+
    "\3\0\26\32\1\131\2\32\22\0\3\32\3\0\3\32"+
    "\1\66\7\32\1\66\15\32\22\0\3\32\3\0\3\32"+
    "\1\132\10\32\1\131\14\32\22\0\3\32\3\0\4\32"+
    "\1\133\24\32\22\0\3\32\3\0\3\32\1\134\25\32"+
    "\22\0\3\32\3\0\12\32\1\135\16\32\22\0\3\32"+
    "\3\0\22\32\1\136\6\32\22\0\3\32\3\0\15\32"+
    "\1\137\13\32\22\0\3\32\3\0\10\32\1\140\20\32"+
    "\22\0\3\32\3\0\3\32\1\141\12\32\1\142\2\32"+
    "\1\143\7\32\22\0\3\32\3\0\14\32\1\120\14\32"+
    "\22\0\3\32\3\0\13\32\1\144\15\32\22\0\3\32"+
    "\3\0\25\32\1\145\3\32\22\0\3\32\3\0\20\32"+
    "\1\146\10\32\7\0\1\147\12\0\3\106\3\0\31\106"+
    "\1\0\2\51\1\110\15\51\1\3\40\51\2\112\1\3"+
    "\1\112\1\4\54\112\22\0\2\115\56\0\3\115\56\0"+
    "\3\32\3\0\2\32\1\150\16\32\1\151\1\152\6\32"+
    "\22\0\3\32\3\0\12\32\1\153\16\32\22\0\3\32"+
    "\3\0\30\32\1\154\22\0\3\32\3\0\10\32\1\155"+
    "\20\32\22\0\3\32\3\0\24\32\1\156\4\32\22\0"+
    "\3\32\3\0\4\32\1\157\24\32\22\0\3\32\3\0"+
    "\10\32\1\160\20\32\22\0\3\32\3\0\4\32\1\161"+
    "\24\32\22\0\3\32\3\0\22\32\1\66\6\32\22\0"+
    "\3\32\3\0\1\162\30\32\22\0\1\32\1\163\1\32"+
    "\3\0\31\32\22\0\3\32\3\0\15\32\1\164\13\32"+
    "\22\0\3\32\3\0\10\32\1\165\20\32\22\0\3\32"+
    "\3\0\14\32\1\166\14\32\22\0\3\32\3\0\23\32"+
    "\1\167\5\32\22\0\3\32\3\0\22\32\1\170\6\32"+
    "\22\0\3\32\3\0\4\32\1\171\24\32\22\0\3\32"+
    "\3\0\2\32\1\172\10\32\1\173\15\32\22\0\3\32"+
    "\3\0\27\32\1\174\1\32\22\0\3\32\3\0\15\32"+
    "\1\175\13\32\22\0\3\32\3\0\4\32\1\176\24\32"+
    "\22\0\3\32\3\0\22\32\1\144\6\32\22\0\3\32"+
    "\3\0\1\66\30\32\22\0\3\32\3\0\22\32\1\177"+
    "\6\32\22\0\3\32\3\0\10\32\1\200\20\32\22\0"+
    "\3\32\3\0\15\32\1\54\13\32\22\0\3\32\3\0"+
    "\4\32\1\201\24\32\22\0\3\32\3\0\1\201\30\32"+
    "\22\0\3\32\3\0\4\32\1\202\24\32\22\0\3\32"+
    "\3\0\7\32\1\66\21\32\22\0\3\32\3\0\13\32"+
    "\1\203\15\32\22\0\3\32\3\0\4\32\1\204\24\32"+
    "\22\0\3\32\3\0\20\32\1\205\10\32\22\0\3\32"+
    "\3\0\21\32\1\206\7\32\22\0\3\32\3\0\20\32"+
    "\1\207\10\32\22\0\3\32\3\0\12\32\1\210\16\32"+
    "\22\0\1\66\2\32\3\0\31\32\22\0\3\32\3\0"+
    "\20\32\1\211\10\32\22\0\3\32\3\0\1\212\30\32"+
    "\22\0\3\32\3\0\22\32\1\213\6\32\22\0\3\32"+
    "\3\0\12\32\1\214\16\32\22\0\3\32\3\0\10\32"+
    "\1\215\20\32\22\0\3\32\3\0\14\32\1\216\14\32"+
    "\22\0\3\32\3\0\4\32\1\217\24\32\22\0\3\32"+
    "\3\0\4\32\1\220\24\32\22\0\3\32\3\0\30\32"+
    "\1\221\22\0\3\32\3\0\14\32\1\222\14\32\22\0"+
    "\3\32\3\0\22\32\1\223\6\32\22\0\3\32\3\0"+
    "\15\32\1\224\13\32\22\0\3\32\3\0\1\225\30\32"+
    "\22\0\3\32\3\0\14\32\1\66\14\32\22\0\3\32"+
    "\3\0\1\226\30\32\22\0\3\32\3\0\1\227\30\32"+
    "\22\0\3\32\3\0\21\32\1\143\7\32\22\0\3\32"+
    "\3\0\4\32\1\230\24\32\22\0\3\32\3\0\10\32"+
    "\1\231\20\32\22\0\3\32\3\0\15\32\1\232\13\32"+
    "\22\0\3\32\3\0\30\32\1\144\22\0\3\32\3\0"+
    "\30\32\1\233\22\0\3\32\3\0\14\32\1\144\14\32"+
    "\22\0\3\32\3\0\20\32\1\234\10\32\22\0\3\32"+
    "\3\0\15\32\1\66\13\32\22\0\3\32\3\0\16\32"+
    "\1\235\12\32\22\0\3\32\3\0\2\32\1\236\26\32"+
    "\22\0\3\32\3\0\21\32\1\150\7\32\22\0\3\32"+
    "\3\0\3\32\1\237\25\32\22\0\3\32\3\0\2\32"+
    "\1\66\11\32\1\66\14\32\22\0\3\32\3\0\3\32"+
    "\1\240\25\32\22\0\3\32\3\0\10\32\1\241\20\32"+
    "\22\0\3\32\3\0\1\32\1\242\27\32\22\0\3\32"+
    "\3\0\14\32\1\243\14\32\22\0\3\32\3\0\12\32"+
    "\1\244\16\32\22\0\3\32\3\0\14\32\1\245\14\32"+
    "\22\0\3\32\3\0\15\32\1\201\13\32\22\0\3\32"+
    "\3\0\15\32\1\246\1\32\1\247\11\32\22\0\3\32"+
    "\3\0\1\54\30\32\22\0\3\32\3\0\12\32\1\250"+
    "\16\32\22\0\3\32\3\0\10\32\1\144\20\32\22\0"+
    "\3\32\3\0\10\32\1\214\20\32\22\0\3\32\3\0"+
    "\4\32\1\251\24\32\22\0\3\32\3\0\20\32\1\66"+
    "\10\32\22\0\3\32\3\0\12\32\1\252\16\32\22\0"+
    "\3\32\3\0\15\32\1\253\13\32\22\0\3\32\3\0"+
    "\22\32\1\254\6\32\22\0\3\32\3\0\30\32\1\255"+
    "\22\0\3\32\3\0\23\32\1\256\5\32\22\0\3\32"+
    "\3\0\10\32\1\257\20\32\22\0\3\32\3\0\15\32"+
    "\1\260\13\32\22\0\3\32\3\0\4\32\1\54\24\32"+
    "\22\0\3\32\3\0\4\32\1\261\24\32\22\0\3\32"+
    "\3\0\10\32\1\262\20\32\22\0\3\32\3\0\4\32"+
    "\1\66\24\32\22\0\3\32\3\0\2\32\1\263\26\32"+
    "\22\0\3\32\3\0\30\32\1\264\22\0\3\32\3\0"+
    "\30\32\1\265\22\0\3\32\3\0\6\32\1\266\22\32"+
    "\22\0\3\32\3\0\1\267\30\32\22\0\3\32\3\0"+
    "\13\32\1\270\15\32\22\0\3\32\3\0\3\32\1\256"+
    "\25\32\22\0\3\32\3\0\23\32\1\271\5\32\22\0"+
    "\3\32\3\0\2\32\1\206\26\32\22\0\3\32\3\0"+
    "\1\54\3\32\1\272\24\32\22\0\3\32\3\0\1\273"+
    "\30\32\22\0\3\32\3\0\14\32\1\150\14\32\22\0"+
    "\3\32\3\0\12\32\1\274\16\32\22\0\3\32\3\0"+
    "\30\32\1\275\22\0\3\32\3\0\17\32\1\247\11\32"+
    "\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8673];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\4\1\1\11\34\1\3\0\1\1\1\0"+
    "\1\1\1\0\32\1\1\0\4\1\1\0\1\11\32\1"+
    "\1\11\126\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[189];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    private Token token(String lexeme, String lexicalComp, int line, int column){
        return new Token(lexeme, lexicalComp, line+1, column+1);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return token(yytext(), "ERROR_1", yyline, yycolumn);
            }
            // fall through
          case 13: break;
          case 2:
            { /*Ignorar*/
            }
            // fall through
          case 14: break;
          case 3:
            { switch (yytext()) {
        case "&" :return token(yytext(), "SEP", yyline, yycolumn);
        case "_" :return token(yytext(), "GBAJO", yyline, yycolumn);
        case "==": return token(yytext(), "IGUALDAD", yyline, yycolumn);
        case "!=": return token(yytext(), "DESIGUALDAD", yyline, yycolumn);
        case ">>": return token(yytext(), "MAYORQUE", yyline, yycolumn);
        case "<<": return token(yytext(), "MENORQUE", yyline, yycolumn);
        case ">=": return token(yytext(), "MAYORIGUALQUE", yyline, yycolumn);
        case "<=": return token(yytext(), "MENORIGUALQUE", yyline, yycolumn);
        case "&&": return token(yytext(), "ANDLOGICO", yyline, yycolumn);
        case "||": return token(yytext(), "ORLOGICO", yyline, yycolumn);
        case "!": return token(yytext(), "NOTLOGICO", yyline, yycolumn);
        case "=": return token(yytext(), "ASIGNACION", yyline, yycolumn);
        case "\'+": return token(yytext(), "INCREMENTO", yyline, yycolumn);
        case "\'-": return token(yytext(), "DECREMENTO", yyline, yycolumn);
        case "++": return token(yytext(), "SUMA", yyline, yycolumn);
        case "--": return token(yytext(), "RESTA", yyline, yycolumn);
        case "**": return token(yytext(), "MULTIPLICACION", yyline, yycolumn);
        case "//": return token(yytext(), "DIVISION", yyline, yycolumn);
        case "%%": return token(yytext(), "MODULO", yyline, yycolumn);
        case "(": return token(yytext(), "PARA", yyline, yycolumn);
        case ")": return token(yytext(), "PARC", yyline, yycolumn);
        case "{": return token(yytext(), "CORA", yyline, yycolumn);
        case "}": return token(yytext(), "CORC", yyline, yycolumn);
        case "[": return token(yytext(), "PARCUAA", yyline, yycolumn);
        case "]": return token(yytext(), "PARCUAC", yyline, yycolumn);
        case ".": return token(yytext(), "PUNTODECIMAL", yyline, yycolumn);
        case ";": return token(yytext(), "FINLINEA", yyline, yycolumn);
        case ",": return token(yytext(), "SEPARADOR", yyline, yycolumn);
        case "\"": return token(yytext(), "COMILLA", yyline, yycolumn);
        case "'": return token(yytext(), "COMILLASIMPLE", yyline, yycolumn);
        case "$": return token(yytext(), "DINERO", yyline, yycolumn);
    }
            }
            // fall through
          case 15: break;
          case 4:
            { return token(yytext(), "NUMERO", yyline, yycolumn);
            }
            // fall through
          case 16: break;
          case 5:
            { return token(yytext(), "IDENTIFICADOR", yyline, yycolumn);
            }
            // fall through
          case 17: break;
          case 6:
            { switch(yytext()) {
        case "VARIABLES": return token(yytext(), "VARIABLES", yyline, yycolumn);
        case "PROCESOS": return token(yytext(), "PROCESOS", yyline, yycolumn);
        /* Operaciones básicas */
        case "SUMA": return token(yytext(), "SUMA", yyline, yycolumn);
        case "RESTA": return token(yytext(), "RESTA", yyline, yycolumn);
        case "MULTIPLICACION": return token(yytext(), "MULTIPLICACION", yyline, yycolumn);
        case "DIVISION": return token(yytext(), "DIVISION", yyline, yycolumn);
        case "MODULO": return token(yytext(), "MODULO", yyline, yycolumn);
        /* Operaciones avanzadas */
        case "POTENCIA": return token(yytext(), "POTENCIA", yyline, yycolumn);
        case "RAIZ_C": return token(yytext(), "RAIZ_CUADRADA", yyline, yycolumn);
        case "RAIZ_N": return token(yytext(), "RAIZ_ENESIMA", yyline, yycolumn);
        case "LN": return token(yytext(), "LOGARITMO_NATURAL", yyline, yycolumn);
        case "LOG10": return token(yytext(), "LOGARITMO_BASE_10", yyline, yycolumn);
        case "EXP": return token(yytext(), "EXPONENCIAL", yyline, yycolumn);
        /* Operaciones trigonométricas */
        case "SEN": return token(yytext(), "SENO", yyline, yycolumn);
        case "COS": return token(yytext(), "COSENO", yyline, yycolumn);
        case "TAN": return token(yytext(), "TANGENTE", yyline, yycolumn);
        case "ARCSEN": return token(yytext(), "ARCOSENO", yyline, yycolumn);
        case "ARCCOS": return token(yytext(), "ARCOCOSENO", yyline, yycolumn);
        case "ARCTAN": return token(yytext(), "ARCOTANGENTE", yyline, yycolumn);
        case "SEN_H": return token(yytext(), "SENO_HIPERBOLICO", yyline, yycolumn);
        case "COS_H": return token(yytext(), "COSENO_HIPERBOLICO", yyline, yycolumn);
        case "TAN_H": return token(yytext(), "TANGENTE_HIPERBOLICA", yyline, yycolumn);
        /* Funciones matemáticas */
        case "ABS": return token(yytext(), "VALOR_ABSOLUTO", yyline, yycolumn);
        case "FACT": return token(yytext(), "FACTORIAL", yyline, yycolumn);
        case "REDONDEO": return token(yytext(), "REDONDEO", yyline, yycolumn);
        case "REDONDEO_MENOS": return token(yytext(), "REDONDEO_HACIA_ABAJO", yyline, yycolumn);
        case "REDONDEO_MAS": return token(yytext(), "REDONDEO_HACIA_ARRIBA", yyline, yycolumn);
        case "MCD": return token(yytext(), "MAXIMO_COMUN_DIVISOR", yyline, yycolumn);
        case "MCM": return token(yytext(), "MINIMO_COMUN_MULTIPLO", yyline, yycolumn);
        /*Comparación*/
        case "IGUAL_A": return token(yytext(), "IGUAL_A", yyline, yycolumn);
        case "DIFERENTE_QUE": return token(yytext(), "DIFERENTE_QUE", yyline, yycolumn);
        case "MAYOR_QUE" : return token(yytext(), "MAYOR_QUE", yyline, yycolumn);
        case "MENOR_QUE" : return token(yytext(), "MENOR_QUE", yyline, yycolumn);
        case "MAYOR_O_IGUAL_QUE": return token(yytext(), "MAYOR_O_IGUAL_QUE", yyline, yycolumn);
        case "MENOR_O_IGUAL_QUE": return token(yytext(), "MENOR_O_IGUAL_QUE", yyline, yycolumn);
        /* Operaciones de estadísticas */
        case "MEDIANA": return token(yytext(), "MEDIANA", yyline, yycolumn);
        case "VAR": return token(yytext(), "VAR", yyline, yycolumn);
        case "DESVESTA": return token(yytext(), "DESVIACION_ESTANDAR", yyline, yycolumn);
        case "PROMEDIO": return token(yytext(), "PROMEDIO", yyline, yycolumn);
        case "SI": return token(yytext(), "SI", yyline, yycolumn);
        case "REPETIR": return token(yytext(), "REPETIR", yyline, yycolumn);
        case "MIENTRAS": return token(yytext(), "MIENTRAS", yyline, yycolumn);
    }
            }
            // fall through
          case 18: break;
          case 7:
            { return token(yytext(), "NDECIMAL", yyline, yycolumn);
            }
            // fall through
          case 19: break;
          case 8:
            { return token(yytext(), "CADENA", yyline, yycolumn);
            }
            // fall through
          case 20: break;
          case 9:
            { return token(yytext(), "TEXTO", yyline, yycolumn);
            }
            // fall through
          case 21: break;
          case 10:
            { return token(yytext(), "ENTERO", yyline, yycolumn);
            }
            // fall through
          case 22: break;
          case 11:
            { return token(yytext(), "DECIMAL", yyline, yycolumn);
            }
            // fall through
          case 23: break;
          case 12:
            { return token(yytext(), "BOOLEANO", yyline, yycolumn);
            }
            // fall through
          case 24: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
