import axios from 'axios';

const API_KEY = 'SUA_CHAVE_API_AQUI'; // Substitua pela sua chave de API do OpenAI
const API_URL = 'https://api.openai.com/v1/chat/completions';

export async function corrigirRedacao(redacao) {
    const prompt_enem = `
Corrija a redação abaixo conforme os critérios oficiais do ENEM, com base nas *5 competências* da redação. Atribua uma *nota de 0 a 200* para cada uma, totalizando 1000 pontos.

➡ *Importante:*
- Se a competência *não puder ser avaliada, ou se o texto **não atender aos critérios mínimos, a nota para essa competência deve ser **ZERO*, conforme as orientações do INEP.
- Justifique claramente *por que a nota foi zero*, citando os critérios infringidos (ex: fuga ao tema, ausência de argumentos, falta de proposta, texto em outro idioma, etc.).
- Em caso de competência *atingida parcialmente*, atribua a nota proporcional, sempre explicando os motivos.
- Se o *tipo textual não for dissertativo-argumentativo, atribua **zero em todas as competências* e indique a anulação conforme o edital.

Analise as seguintes competências:

1. *Competência I – Domínio da norma culta da língua escrita:*
   - Avalie ortografia, acentuação, pontuação, concordância e vocabulário.
   - Se o texto for ilegível ou apresentar erros graves e recorrentes, atribua *nota 0*.

2. *Competência II – Compreensão da proposta e desenvolvimento do tema:*
   - Verifique se há compreensão integral da proposta.
   - Em caso de *fuga total do tema, **cópia integral* dos textos motivadores ou *menos de 8 linhas autorais, atribua **nota 0*.

3. *Competência III – Seleção e organização dos argumentos:*
   - Se o texto não apresenta argumentos ou defesa de ponto de vista, ou apenas repete informações sem organização lógica, atribua *nota 0*.

4. *Competência IV – Coesão textual:*
   - Avalie a articulação entre as partes do texto, conectivos, fluidez e progressão.
   - Se o texto for incoerente ou desconexo, atribua *nota 0*.

5. *Competência V – Proposta de intervenção:*
   - Avalie a presença de *agente, ação, meio, finalidade* e respeito aos direitos humanos.
   - Se *não houver proposta de intervenção, ou se a proposta for incoerente, impraticável ou **ferir direitos humanos, atribua **nota 0*.

No final, apresente:

🔹 *Notas por competência* (de 0 a 200).  
🔹 *Nota total* (soma das competências, de 0 a 1000).  
🔹 *Justificativas detalhadas* para cada competência.  
🔹 *Destaque dos principais erros* gramaticais, argumentativos e estruturais.  
🔹 *Sugestões específicas* para melhorar o texto.  
🔹 *Comentário geral* motivador, com orientações de aprimoramento.

traga as competências e a nota final em objeto json no seguinte modelo:
  {
    competencia1: {
      nota: nota,
      justificativa: Explicação detalhada
    },
    competencia2: {
      nota: nota,
      justificativa: Explicação detalhada
    },
    competencia3: {
      nota: nota,
      justificativa: Explicação detalhada
    },
    competencia4: {
      nota: nota,
      justificativa: Explicação detalhada
    },
    competencia5: {
      nota: nota,
      justificativa: Explicação detalhada
    },
    nota_total: notaTotal,
}

Responda estritamente no formato JSON, com aspas nas chaves e valores, sem comentários e sem texto fora do JSON.

Aqui está a redação a ser avaliada:
`;

    const headers = {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${API_KEY}`,
    };

    const body = {
        model: 'gpt-4',
        messages: [
            {
                role: 'system',
                content:
                    'Você é um corretor profissional do ENEM, treinado para corrigir redações conforme os critérios oficiais do INEP, com clareza e imparcialidade.',
            },
            {
                role: 'user',
                content: prompt_enem + '\n\n' + redacao,
            },
        ],
        temperature: 0.2,
    };

    try {
        const response = await axios.post(API_URL, body, {headers});
        return response.data.choices[0].message.content;
    } catch (error) {
        console.error('Erro na correção:', error);
        throw error;
    }
}
