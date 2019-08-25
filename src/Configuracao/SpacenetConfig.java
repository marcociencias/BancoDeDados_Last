/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracao;

import Spacenet.FormBD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author marco.junior
 */
public class SpacenetConfig {
    
    public String Configuracao(String banco , String instancia, String bancoSAC , String instanciaSAC , String config) throws IOException{
        String conteudo = "";
         try (FileWriter arquivo = new FileWriter(config+"\\Spacenetconfig.txt",false)) {
            BufferedWriter escreve = new BufferedWriter (arquivo);

            escreve.write("StrDataBase =" +banco);
            escreve.newLine();
            
            escreve.write("StrDBServer =" +instancia);
            escreve.newLine();
            
            escreve.write("StrSACDataBase=" +bancoSAC);
            escreve.newLine();
            
            escreve.write("StrSACServer =" +instanciaSAC);
            escreve.newLine();
  
            FileReader arq = new FileReader(config+"\\Spacenetconfig_Parametros.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            while(linha != null)
            {
                conteudo += linha + "\r\n";
                linha = lerArq.readLine();
                System.out.println(""+conteudo);
            }
            escreve.write(conteudo);
            escreve.close();
        }catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null,"Erro : " +ex.getMessage());
        }
        
        return null;
    }
     public String SpacenetConfig(String config) throws IOException
     {
         String padrao = ""
                 + "[Modes]\n" +"\r\n"+
"TimeDB = 1000\r\n" +
"SIAC = 0\n" +"\r\n"+
"OptNormBtnShow = 1\n" +
"PDVMifare = 1\r\n" +
"ServerFeature = 1\r\n" +
"ServerPort = 63767\r\n" +
"TimeAdjustSynchroTime = 06:00\r\n" +
"TimeAdjustSynchroTime = 12:00\r\n" +
"TimeAdjustSynchroTime = 18:00\r\n" +
"TimeAdjustSynchroTime = 23:00\r\n" +
"BlackListSynchroTime = 04:00\r\n" +
"xDPlusIP = 192.168.0.51\r\n" +
"xDPlusPort = 2563\r\n" +
"DPlusTimeOutMSecs = 1500\r\n" +
"DPlusInReader = 11\r\n" +
"DPlusPayReader = 12\r\n" +
"DPlusExitReader = 12\r\n" +
"DPlusXvpcReader = 12\r\n" +
"DPlusInNeededArea = 0\r\n" +
"DPlusPayNeededArea = 1\r\n" +
"DPlusExitNeededArea = 1\r\n" +
"DPlusXvpcNeededArea = 1\r\n" +
"DPlusInValMinutes = -1\r\n" +
"DPlusPayValMinutes = 20\r\n" +
"DPlusExitValMinutes = 15\r\n" +
"EnDateTimeShow = 1 \r\n" +
"EnBListFromCtrl = 1\r\n" +
"DPlusDoAllwaysGetDbLastSeq = 1\r\n" +
"\n" +
"\n" +
"AutoConnect = 1\r\n" +
"\n" +
"EstaparEmpresa = 0\r\n" +
"EstaparFilial  = 0\r\n" +
"\n" +
"|Utilizado para esconder o progresso do comunicador automaticamente|\r\n" +
"showMemo = 1\r\n" +
"\n" +
"|Utilizado para habilitar ou desabilitar o SAC nos aplicativos Spacenet|\r\n" +
"DisableLogin = 1\r\n" +
"\n" +
"|Utilizado apra desabilitar o SAC no Comunicador|\r\n" +
"DisableLoginComm = 1\r\n" +
"\n" +
"[DBTRANS_N2]\r\n" +
"Est_id = 1\r\n" +
"Ecr_id = 20\r\n" +
"DBTransPath = \\\\192.168.0.222\\publica\r\n" +
"SeqDbt =78\r\n" +
"DBTransInterval = 300\r\n" +
"DBTransPort = 12350\r\n" +
"DBTransIp = 192.168.0.234\r\n" +
"\n" +
"[CONTROLE]\r\n" +
"\n" +
"|Utilizado como botão de pânico para envio de comando para múltiplas cancelas            |\r\n" +
"|0 	Não habilitado                                                                       |\r\n" +
"|1 	Comando enviado para entradas, passagens e saídas                                    |\r\n" +
"|2 	Comando enviado para todas as entradas                                               |\r\n" +
"|3 	Comando enviado para todas as passagens e saídas                                     |\r\n" +
"|4 	Comando enviado para entradas, passagens, saídas, caixas de entrada, caixas de saída |\r\n" +
"|5 	Comando enviado para passagens, saídas, caixas de saída                              |\r\n" +
"|6 	Comando enviado para entradas, caixas de entrada                                     |\r\n" +
"MultipleBarriers = 4\r\n" +
"\n" +
"|IRREGULARIDADES: Ao alterar cartões atualizar versão para esta|\r\n" +
"CardVersionChange = 1\r\n" +
"\n" +
"|Controle - controle de vagas tela completa|\r\n" +
"|0 = não aparece coluna do DBTrans         |\r\n" +
"|1 = aparece coluna do DBTrans             |\r\n" +
"ControleVagasUtilizaDBTrans = 0\r\n" +
"\n" +
"|Controle - controle de vagas tela completa|\r\n" +
"|0 = não aparece coluna do ViaFacil        |\r\n" +
"|1 = aparece coluna do ViaFacil            |\r\n" +
"ControleVagasUtilizaViaFacil = 0\r\n" +
"\n" +
"|Qual tela mostrar    |\r\n" +
"|0 = Tela completa    |\r\n" +
"|1 = Tela simplificada|\r\n" +
"ControleTelaControleVagas = 0\r\n" +
"\n" +
"||TELA CONTROLE DE VAGAS - SIMPLIFICADA||\r\n" +
"\n" +
"|Mostra ou não valores de pagamento|\r\n" +
"|0 = Não mostra|\r\n" +
"|1 = Mostra    |\r\n" +
"ControleMostraValoresPagamento = 0\r\n" +
"\r\n" +
"[CONTROLE E COMUNICADOR - Controle de vagas]\r\n" +
"|Pelo Comunicador:Horário para zerar vagas          |\r\n" +
"|Pelo Controle: Horário para selecionar dados       |\r\n" +
"|Horario para escolher um horário específico        |\r\n" +
"|DB ou sem este registro para o Day Change do banco |\r\n" +
"HorarioZeraControleVagas = DB\r\n" +
"\n" +
"[CONFIGURADOR]\r\n" +
"\n" +
"|| CRIAÇÃO DE CARTOES MENSALISTAS ||\r\n" +
"\n" +
"|NUMERO DO LOTE (DECIMAL)|\r\n" +
"LotNumber = 2456\r\n" +
"\n" +
"|NUMERO DO SUBLOTE|\r\n" +
"SubLotNumber = 00 \r\n" +
"\n" +
"|NUMERO DE INICIO DO TIPO MENSALISTAS|\r\n" +
"NumberTypeStart = 6\r\n" +
"\n" +
"|NUMERO DE FIM DO TIPO MENSALISTAS|\r\n" +
"NumberTypeEnd = 8\r\n" +
"\n" +
"|MODO|\r\n" +
"Mode = e\r\n" +
"\n" +
"|VERSAO|\r\n" +
"CardVersionCreate = 3\r\n" +
"\n" +
"|CARTOES EXTRA EM MENSALISTAS|\r\n" +
"|0 = Desabilitado            |\r\n" +
"|1 = Habilitado              |\r\n" +
"EnableExtraCards = 0\r\n" +
"\n" +
"|LEITOR DE PROXIMIDADE|\r\n" +
"|0 = NENHUM           |\r\n" +
"|1 = ACURA            |\r\n" +
"|2 = HID              |\r\n" +
"EnableProximity = 0\r\n" +
"\n" +
"|PORTA COMM SERIAL PROXIMITY|\r\n" +
"SerialCommPortProximity = 1\r\n" +
"\n" +
"|| CRIAÇÃO DE CARTÕES MENSALISTA DBTRANS ||\r\n" +
"\n" +
"|Porta servidor DBTrans|\r\n" +
"DBTransPort = 12350\r\n" +
"\n" +
"|Ip servidor DBTrans|\r\n" +
"DBTransIp = 192.168.1.150\r\n" +
"\n" +
"|Exibe Campos DBTrans nas abas Mensalistas e Atualiza BC|\r\n" +
"hasDbtrans = 0\r\n" +
"\r\n" +
"|PERMITE DELETAR CARTÕES DBTrans pela Aba Mensalistas|\r\n" +
"EnableDeleteDbtCardConfig = 0";

         FileWriter spacenetconfig = new FileWriter (config+"\\Spacenetconfig_parametros.txt");
         BufferedWriter criar = new BufferedWriter(spacenetconfig);
         
         criar.write(padrao);
         criar.close();
         JOptionPane.showMessageDialog(null,"Arquivo padrão SpacenetConfig Parametros !!! ");
         
         return null;
     }    
 
 public void configuracao(String local) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException, IOException
{
     try
    {
    DocumentBuilderFactory document = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = document.newDocumentBuilder();
    org.w3c.dom.Document documentoXML = documentBuilder.newDocument();
    Element root = documentoXML.createElement("root");
    documentoXML.appendChild(root);
    Element Configuracao = documentoXML.createElement("Configuracao");
    
    Attr id = documentoXML.createAttribute("ID");
    id.setValue("1");
    Configuracao.setAttributeNode(id);
    root.appendChild(Configuracao);
        
             
    Element Local = documentoXML.createElement("Local");
    Local.appendChild(documentoXML.createTextNode(""));
    Configuracao.appendChild(Local);    
            
    Element Banco = documentoXML.createElement("Banco");
    Banco.appendChild(documentoXML.createTextNode(""));
    Configuracao.appendChild(Banco);
    
    Element Diretorio = documentoXML.createElement("Diretorio");
    Diretorio.appendChild(documentoXML.createTextNode("C:\\RBACKUP\\CONFIGBACKUP.XML"));
    Configuracao.appendChild(Diretorio);
    
    Element Path = documentoXML.createElement("Path");
    Path.appendChild(documentoXML.createTextNode(""));
    Configuracao.appendChild(Path);
    
    Element Config = documentoXML.createElement("Config");
    Config.appendChild(documentoXML.createTextNode(""));
    Configuracao.appendChild(Config);

      
    TransformerFactory transformerfactory = TransformerFactory.newInstance();
    
    Transformer transformer = transformerfactory.newTransformer();
    
    DOMSource documentoFonte = new DOMSource(documentoXML);
    
    StreamResult documentoFinal = new StreamResult(new File(local));
    
    transformer.transform(documentoFonte, documentoFinal);
   // System.out.println("Arquivo criado com sucesso");
    }
           catch (ParserConfigurationException ex) {
            Logger.getLogger(FormBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FormBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(FormBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
 
}



       
