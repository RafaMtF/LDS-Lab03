"use client";

import Navigation from "@/components/BtnGoBack";
import Navigator from "@/components/BtnGoBack";
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import React, { useEffect, useState } from "react";

function Page(props) {
  const [aluno, setAluno] = useState({});
  const [extratos, setExtratos] = useState([]);

  const id = props.params.id;

  useEffect(() => {
    fetch(`http://localhost:8081/aluno/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setAluno(data);
      });
  }, [id]);

  useEffect(() => {
    fetch(`http://localhost:8081/api/extrato/aluno/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setExtratos(data);
      });
  });

  return (
    <div className="w-[65vw] h-[100vh] center m-auto mt-4">
      <h1 className="text-4xl font-bold">Extrato</h1>
      
      <Table>
        <TableCaption>Extrato de moedas</TableCaption>
        <TableHeader>
          <TableRow>
            <TableHead>Data</TableHead>
            <TableHead>Quantidade</TableHead>
            <TableHead>Descrição</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {extratos.map((extrato) => {
            return (
              <TableRow key={extrato.id}>
                <TableCell>{extrato.dataHora}</TableCell>
                <TableCell>{extrato.quantidadeMoedas}</TableCell>
                <TableCell>{extrato.motivo}</TableCell>
              </TableRow>
            );
          })}
        </TableBody>
      </Table>
      {extratos.map((extrato) => {
        return (
          <div key={extrato.id}>
            <h1>{extrato.quantidaeMoedas}</h1>
          </div>
        );
      })}
    </div>
  );
}

export default Page;
