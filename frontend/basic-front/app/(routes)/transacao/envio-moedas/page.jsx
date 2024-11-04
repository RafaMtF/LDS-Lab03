"use client";

import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";

export default function Page() {
  const [transacao, setTransacao] = useState({
    professorId: "",
    alunoId: "",
    quantidade: "",
    motivo: "",
  });

  function onSubmit() {
    fetch("http://localhost:8081/transacoes/enviar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(transacao),
    });
    console.log(transacao);
  }

  useEffect(() => {
    console.log("Transacao", transacao);
  }, [transacao]);

  return (
    <div className="p-8">
      <h1 className="text-2xl font-semibold">Enviar moedas:</h1>
      <form onSubmit={onSubmit}>
        <div className="flex flex-col space-y-4 mt-4">
          <input
            type="text"
            placeholder="id do professor"
            value={transacao.professorId}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setTransacao({ ...transacao, professorId: e.target.value })}
          />
          <input
            type="text"
            placeholder="id do aluno"
            value={transacao.alunoId}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setTransacao({ ...transacao, alunoId: e.target.value })}
          />
          <input
            type="number"
            placeholder="Quantidade de moedas a ser enviada"
            value={transacao.quantidade}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setTransacao({ ...transacao, quantidade: e.target.value })}
          />
          <input
            type="text"
            placeholder="Motivo"
            value={transacao.motivo}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setTransacao({ ...transacao, motivo: e.target.value })}
          />
          <Button type="submit" className="bg-green-500">
            Enviar
          </Button>
        </div>
      </form>
    </div>
  );
}
