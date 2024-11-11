"use client";

import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";

export default function Page() {
  const [empresa, setEmpresa] = useState({
    nome: "",
    imagem: "",
  });

  function onSubmit() {
    fetch("http://localhost:8081/empresa-parceira", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(empresa),
    });
  }

  return (
    <div className="p-8">
      <h1 className="text-2xl font-semibold">Criar empresa:</h1>
      <form onSubmit={onSubmit}>
        <div className="flex flex-col space-y-4 mt-4">
          <input
            type="text"
            placeholder="Nome"
            value={empresa.nome}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setEmpresa({ ...empresa, nome: e.target.value })}
          />
          <input
            type="text"
            placeholder="Imagem"
            value={empresa.imagem}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setEmpresa({ ...empresa, imagem: e.target.value })}
          />
          <Button type="submit" className="bg-green-500">
            Criar empresa
          </Button>
        </div>
      </form>
    </div>
  );
}
