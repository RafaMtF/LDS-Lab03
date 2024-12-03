import { FaWallet } from "react-icons/fa";
import Link from "next/link";
import React from "react";
import {
  Tooltip,
  TooltipContent,
  TooltipProvider,
  TooltipTrigger,
} from "./ui/tooltip";

function NavBarAluno({ aluno }) {
  return (
    <>
      <div className="w-[100vw] h-24 bg-[#23CE6B] px-8">
        <div className="flex items-center justify-between h-full">
          <div className="flex items-center">
            <Link href={`/aluno`}>
              <p className="text-4xl font-bold text-white">{aluno?.nome}</p>
            </Link>
          </div>
          <div className="flex items-center text-white font-semibold text-2xl">
            Saldo: {aluno?.saldo}
            <div className="ml-3">
              <TooltipProvider>
                <Tooltip>
                  <TooltipTrigger>
                    <Link href={`/aluno/extrato/${aluno?.id}`}>
                      <div className="flex items-center text-xl bg-blue-500 hover:bg-blue-400 p-3 border-0 rounded-md">
                        <FaWallet />
                      </div>
                    </Link>
                  </TooltipTrigger>
                  <TooltipContent>
                    <span>Extrato</span>
                  </TooltipContent>
                </Tooltip>
              </TooltipProvider>
            </div>
          </div>
        </div>
      </div>
      <div className=""></div>
    </>
  );
}

export default NavBarAluno;
