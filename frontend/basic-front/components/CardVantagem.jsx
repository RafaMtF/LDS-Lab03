import React from "react";
import { Button } from "./ui/button";
import Image from "next/image";

function CardVantagem({ vantagem, aluno }) {
  const resgatarVantagem = () => {
    fetch("http://localhost:8081/api/cupons/resgatar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        alunoId: aluno.id,
        vantagemId: vantagem.id,
      }),
    })
      .then((res) => res.json())
      .then((data) => {
        alert("Vantagem resgatada com sucesso!");
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="border-0 rounded p-2 my-4 bg-slate-100">
      <div className="h-20 border-0 rounded-t-md">
        {/* Implementar com a visualizaçao da imagem */}
        {vantagem.imagem ? (
          <Image href={vantagem.foto} alt="Imagem da vantagem" />
        ) : (
          <p>Imagem não disponível</p>
        )}
      </div>
      <p>{vantagem.descricao}</p>
      <div className="flex justify-end mt-2">
        <p className=" font-semibold">{vantagem.custoMoedas} moedas</p>
      </div>
      {aluno ? (
        <div className="mt-2 w-full">
          <Button variant={"create"} onClick={() => resgatarVantagem()}>Resgatar</Button>
        </div>
      ) : null}
    </div>
  );
}

export default CardVantagem;
