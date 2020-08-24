package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jingchao Zhang
 * Date: 2020-08-22
 * Time: 4:00 PM
 */
public class P1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String product : products) {
            Trie curr = root;
            char[] chars = product.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                if (curr.next[c - 'a'] == null) {
                    curr.next[c - 'a'] = new Trie();
                }
                sb.append(c);
                curr = curr.next[c - 'a'];
            }
            curr.word = sb.toString();
        }

        List<List<String>> res = new ArrayList<>();
        char[] chars = searchWord.toCharArray();
        Trie curr = root;
        for (char c : chars) {
            List<String> list = new ArrayList<>();
            if (curr != null) {
                curr = curr.next[c - 'a'];
                list = dfs(list, curr);
            }
            res.add(list);
        }
        return res;
    }

    private List<String> dfs(List<String> list, Trie node) {
        if (node == null) {
            return list;
        }
        if (node.word != null) {
            list.add(node.word);
        }
        if (list.size() == 3) {
            return new ArrayList<>(list);
        }
        for (Trie next : node.next) {
            if (next != null) {
                List<String> result = dfs(list, next);
                if (result.size() == 3) {
                    return new ArrayList<>(list);
                }
            }
        }
        return list;
    }

    static class Trie {
        Trie[] next = new Trie[26];
        String word;
    }

    public static void main(String[] args) {
        String[] products = {"ilpxatcgvfbmfunpljkodnbfaowi","ilpsokmmniywxgbeqrpsaqeqn","talrnwemajlqicbkxjyf","sbqhbuvkvntmsutdpyavojqwinxofhvhecbtjjkwdkaazftxvgvicgio","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiameutvrtqwucjp","l","ilpxywtmdnlil","rnjutrkyojwumoyrgzx","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyrhxnvfqsuymujmvkwctobnuvrusbqt","ilpxatcgvfblxfvbnoxgmmpvqqvxqyuecwpbjtlzwmmcwspztjjxevjpxdnzcectypljpkjoilnvur","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdkwrfizkvef","ffngjbmfkxtstjbzalnutfiybfy","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaipwtaovnfhuzu","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuamwsmzfbbtgnfsbujeotpndobpdg","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbl","ilpxatcfeexjqxghbengdcvsljajqaxidzitqjfjpovxmijvofntfelqidcbekzecqodiralswkjqckrpz","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrklmagbqeadtwhndgodzgfejjcs","hp","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxovkmfvxdiuceqbvczetytkfvcfykt","ktihatqubvuvnszewdlcyfqclgwhwsrawtcpdvxwhmvaftzkrvu","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexgkoeppszhfbajvcxuaplxeobzyqe","ilpxatcgvfblxfvbnoxgmmpvdxthphkvtcfhpevifbuzgcmxqjvtukbgeppeaufwgjbdfppxwszavitpctqthp","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqzxnhaplrwcgwjkr","ilpxatcgvfkvqfnblpdvtesdandbeynurlcjwwrellxigbsfjccihrvfbsbtcscblctnzededcajrywkj","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypexgkrbzdzmsbimuycjfk","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirysflyamgemsnjibnfxbke","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetvkcqmhquleujnmi","edmasudelavobnlbrj","zgjrwqhoqvmaaasqmggcuahifrwwrfrtpvchkuvncpvugmizhpfiokijxwlssapntpecbdgwteqvfdzwu","ilpxatcgvfblxfvbnoxgmmpvimowoccdedopz","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwhchcgi","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdtdvk","lnpadggtvd","xbnfiostesudukxgghwolzawxqlovbnjweddrqcisujmuhsazvetxrsyqdaidrmfomwmanghqn","zgmmrzerbzujlgomosxmgihordwpzvbnywczhosikslzlaqfyqnrjfbqzqwvihzojyzswbdxczknclmuyhdc","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamclkswqd","gdqdyysurpvmakyesqoeipuvxlhnffgemhvswyvkbgatxuufhbuitjwnvvigwfweiordqdhtnzagjputzale","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaxcp","ilpxatcgvfblxfvbnoxgmmkmnlolyewtuuosejmgconmcjep","ilpxatcgvfblxfvbnoxgmmpvimowocjrj","ilpxatcgvfblxfvbnoxgmmpvimowoccbsqkdevdkizvlnrl","wyeisnjhrhossmnpnexjqbkcsorccgawfgifsmwfdqqadgqdgpfoiagyxperbshwzbnoqqyjr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcmsdqhbizk","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdqlhdjfflb","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxiedjqmul","tzkwqsmwdhczbqnimbzgguyqvtywcyzkqhnkdtknumpuikfexldysotnndztwootn","ilpxatcsfwrpusskcsmzunvejmfymcvs","usoaljtodfybvquycywtnvivvdvbvymivvc","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiobdewutljgvugibawjskriuxeiwishfimbsinzt","orrcvinutuqbzlaxrfhsbpjoonsjrubyrbbdghhqnwjz","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqncvydjmnouqktixtgjtvkmwciiuso","jponpctybxuxtnigdqortyqjiobgdaehgybozbtvxalhyubibburfsjukhalynnkvjr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofpsbqljapaqco","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaegtshdqrhtimpvnbymwrlmvghl","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxgcyqcrmwlrjlbnqqfuhypqgiurkyapxzrdsnbeifik","ilpxatcgvfblxfvbnoxgmmiiubtvodpzwgdgoobsbbnlfjldpqydwejvfysrwhmhg","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqp","dpwgvxdrbzlh","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpufytsqrkyhiehtjkgohchjkmxcx","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiiwstxiirty","irjbjafrvdcpqanwt","ilpxatcgvn","ilpxatcgvfblxfvbnoxuherdhypducgxsuftiappkjfcqvorxizvdlgswfrqveuhlzitltnushzs","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrypwuijbjublekmxhchhnaxbhbgdaqifvdrfvheqiqcswrskd","ilpxatcgvtqdvgovjgabbmkdicgymudbikvhihpxfmpanjyp","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamiuzrrvibhkwigjgrqfhn","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlym","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqismi","jtbuygbbtdyasdtcuswpbquuhswfciyndfton","ilpxxishsvmt","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvfgdtlfrwklzcwqmbmefnxwrtkpak","ilpxatcgvfblxfvbnoxgmmpvimowoumiglwjrzletaydenogpldiblrwpyjeqjeow","hlwga","ilpxatcgvfblxfvbnjyryxxfayspcrqkvyopfzspzmmhhalwjvfhsgybgkzctlqtr","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofewrprmowynq","qyuthohyzttitkgfrfybiuuvzzcqbddrbby","uinnxgnuuptrxhbhplcdklstqbamsxwaeubppeutqlgngtgzycxpcqjabucoi","ilpxatcgvfblxfvrpbuumlvymcimuothjdhlsgenxxcllwfibvvcavuiuesgdjhsgoxjzechjhwnprmut","btrvkwzfdovyyycfxwmxhutvldkblvrsmeyktlwnmdmdepjnkrzkmnerxesvycbrpghnf","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycltcndobbsywuhxohkzostnacjyhj","dijc","ilpxatcgvfblxfvbnoxgmmpvimowoccdednjkkgwtekjv","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcwqxooniui","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyuhbnoibkpmygmul","potullxiksrpnhngusckddvrtylgwztzxmmgvtrlbgwkgbgohsgbljroghmpwrwupszmkv","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoqpodgpsgmlj","ryfoisftsawa","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqexqy","fzvfyiqrwbserbdnnymmcaokpasfpijvbwdxnbctzekkgcudayqlnsclgcxkaeslihczwxphyqbdyxthpuprxjb","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpvoltdohcmslq","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdeyozknywbktmyzkm","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqlc","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypsan","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiarrqyflykjdwvnvicearpou","yfilpbgdkfmphopolcvjbemkpqcqvcxdkkolpwgco","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztckwzvayxyzaqpm","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywb","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaisnakhppbhnofpnuns","khdyqeswcmriitjysdj","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpnupiwbdseowsrurzjiscnitdqncuyzxvkuiskezqy","ilpxatcgvfovxvhriwhgpadztzfcdfgnhktkhqhjiueszhzjpmxrzfgccxovsqxo","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnvncgupn","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetabyivtjxivaraiwg","zvtcdlbjbnlnadytwqwrnbjomdlmmujvwpmazwbjwippucsujioeevltrrdfivkamxgjtrqckuflvpnbsbrhda","apkqpncsbbiqstfxplizqbpriqywwjiwquzpfyhwyxfcucwcs","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetjoolenqclkstqazwb","bjvozgbmtqdxyfirqwhebtijcwrebvdkxtxoahqsjtofybvh","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukfuxkg","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycqgxdkpnisqsfzlkmnpstbd","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrwh","ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkygsrgv"};
        String searchWord = "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywrywcjmtvaleckwduejlayguredkubbcqhtiafhcsmlgdmpcdouxdyxykmujehtpkjqfbrbyehjcnymgumqwbfouubonhzhvssjmpudpvjtdlurkbwyahtclafjaztcdxstgpsvhbbyndqhfkyycxnrvitcasubhnaeolgmmmedgzqtpjjhtlkwqcnjgwehbriwiklwniobbzhegbisgwccvstmdqyneolakaakrnzhmczxdoxhelbezsggbrzlzrrecyvzvrteofqopamraasigegtovcspphlpmsxsfkouohlwdvgrttzltyojunyvmlmhjjihubmkkbrvsbbdiejimobknxcwntoaqltofqopslhzobiuqhlxivctogflejhdlulda";
        List<List<String>> result = new P1268().suggestedProducts(products, searchWord);
        System.out.println("result = " + result);
    }
}
