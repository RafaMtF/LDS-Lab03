"use client";

import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button";
import Link from "next/link";

function Page() {
  const [vantagens, setVantagens] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/oferta")
      .then((res) => res.json())
      .then((data) => setVantagens(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className={"p-8 h-[100vh]"}>
      <div className={"flex justify-between"}>
        <h1 className={"text-2xl font-semibold"}>Vantagens</h1>
      </div>
      <div className={"mt-3 p-4 grid grid-cols-3 gap-2"}>
        {vantagens.length > 0 ? (
          vantagens.map((vantagem) => (
            <div
              key={vantagem.id}
              className={"border-0 rounded-lg bg-slate-100 p-2"}
            >
              <h1 className={"text-xl font-semibold"}>{vantagem.descricao}</h1>
              <p>Valor: {vantagem.custoMoedas} moedas</p>
              <div className={"flex justify-between"}>
                <Button className={"bg-green-400 text-black"}>
                  <Link href="">Regatar vantagem</Link>
                </Button>
              </div>
            </div>
          ))
        ) : (
          <>Vantagens não encontrados</>
        )}
      </div>
    </div>
  );
}

export default Page;
